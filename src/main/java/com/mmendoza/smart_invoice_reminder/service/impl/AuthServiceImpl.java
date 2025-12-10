package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.config.security.JwtService;
import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.recors.RegisterRequest;
import com.mmendoza.smart_invoice_reminder.mapper.AuthenticationMapper;
import com.mmendoza.smart_invoice_reminder.service.AuthService;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import com.mmendoza.smart_invoice_reminder.service.UserService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final TokenService tokenService;
    private final AuthenticationMapper authenticationMapper;

    private static final String ERROR_VALIDATING_TOKEN = "Error validating refresh token";

    public AuthServiceImpl(UserService userService, JwtService jwtService, TokenService tokenService, AuthenticationMapper authenticationMapper) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.tokenService = tokenService;
        this.authenticationMapper = authenticationMapper;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = userService.createUser(authenticationMapper.buildCreateUserRequest(request));
        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        tokenService.saveUserToken(refreshToken, user);
        return authenticationMapper.buildAuthenticationResponse(jwt, refreshToken);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userService.findUserByEmail(request.email());
        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllTokens(user.getId());
        tokenService.saveUserToken(refreshToken, user);
        return authenticationMapper.buildAuthenticationResponse(jwt, refreshToken);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        String oldRefreshToken = authHeader.substring(7);
        try {
            String userEmail = jwtService.extractUsername(oldRefreshToken);
            if (userEmail == null) return;
            User user = userService.findUserByEmail(userEmail);
            if (!jwtService.isTokenValid(oldRefreshToken, user)) return;
            //Genero nuevos tokens de acceso y refresco
            String newAccessToken = jwtService.generateToken(user);
            String newRefreshToken = jwtService.generateRefreshToken(user);
            revokeAllTokens(user.getId());
            tokenService.saveUserToken(newRefreshToken, user);
            AuthenticationResponse authResponse =
                    authenticationMapper.buildAuthenticationResponse(newAccessToken, oldRefreshToken);
            new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
        } catch (Exception e) {
            throw new JwtException(ERROR_VALIDATING_TOKEN, e);
        }
    }

    private void revokeAllTokens(Long userId) {
        List<Token> validUserTokens = tokenService.findAllValidTokenByUser(userId);
        if (validUserTokens.isEmpty()) {
            return;
        }
        tokenService.revokeAllTokensByUser(userId);
    }
}

