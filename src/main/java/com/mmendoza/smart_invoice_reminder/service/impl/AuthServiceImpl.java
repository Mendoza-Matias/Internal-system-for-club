package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.config.security.JwtService;
import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.RegisterRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.InvalidCredentialsException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.AuthenticationError;
import com.mmendoza.smart_invoice_reminder.mapper.AuthenticationMapper;
import com.mmendoza.smart_invoice_reminder.mapper.UserDetailsMapper;
import com.mmendoza.smart_invoice_reminder.service.AuthService;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import com.mmendoza.smart_invoice_reminder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final TokenService tokenService;
    private final AuthenticationMapper authenticationMapper;
    private final UserDetailsMapper userDetailsMapper;

    public AuthServiceImpl(UserService userService, JwtService jwtService, TokenService tokenService, AuthenticationMapper authenticationMapper, UserDetailsMapper userDetailsMapper) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.tokenService = tokenService;
        this.authenticationMapper = authenticationMapper;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = userService.createUser(authenticationMapper.toCreateUserRequest(request));

        String jwt = jwtService.generateToken(userDetailsMapper.toUserDetails(user));
        String refreshToken = jwtService.generateRefreshToken(userDetailsMapper.toUserDetails(user));

        tokenService.saveUserToken(refreshToken, user);

        return authenticationMapper.toAuthenticationResponse(jwt, refreshToken);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        User user = userService.findUserByEmail(request.email())
                .orElseThrow(() -> new InvalidCredentialsException(
                        AuthenticationError.INVALID_CREDENTIALS.getMessage()
                ));

        return generateAndSaveTokens(user);
    }

    @Override
    public AuthenticationResponse refreshToken(String oldRefreshToken) {

        String refreshToken = oldRefreshToken.substring(7);

        String userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail == null) {
            throw new InvalidCredentialsException(AuthenticationError.INVALID_CREDENTIALS.getMessage());
        }

        User user = userService.findUserByEmail(userEmail)
                .orElseThrow(() -> new InvalidCredentialsException(
                        AuthenticationError.INVALID_CREDENTIALS.getMessage()
                ));

        if (!jwtService.isTokenValid(refreshToken, userDetailsMapper.toUserDetails(user))) {
            throw new InvalidCredentialsException(AuthenticationError.INVALID_CREDENTIALS.getMessage());
        }

        return generateAndSaveTokens(user);
    }

    private AuthenticationResponse generateAndSaveTokens(User user) {

        revokeAllTokens(user.getId());

        String accessToken = jwtService.generateToken(userDetailsMapper.toUserDetails(user));
        String refreshToken = jwtService.generateRefreshToken(userDetailsMapper.toUserDetails(user));

        tokenService.saveUserToken(refreshToken, user);

        return authenticationMapper.toAuthenticationResponse(accessToken, refreshToken);
    }

    private void revokeAllTokens(Long userId) {

        List<Token> validUserTokens = tokenService.getAllValidTokensOfAUser(userId);

        if (validUserTokens.isEmpty()) {
            return;
        }

        tokenService.revokeAllOfAUserTokens(userId);
    }
}

