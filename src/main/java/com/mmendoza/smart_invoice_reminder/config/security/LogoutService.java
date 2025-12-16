package com.mmendoza.smart_invoice_reminder.config.security;

import com.mmendoza.smart_invoice_reminder.exceptions.LogoutException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.LogoutError;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class LogoutService implements LogoutHandler {

    private final TokenService tokenService;
    private final JwtService jwtService;

    public LogoutService(TokenService tokenService, JwtService jwtService) {
        this.tokenService = tokenService;
        this.jwtService = jwtService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, @Nullable Authentication authentication) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        String token = jwtService.extractBearerOfToken(authHeader);

        tokenService.revokeTokenWithToken(token);
        SecurityContextHolder.clearContext();
    }

}
