package com.mmendoza.smart_invoice_reminder.config.security;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogoutService implements LogoutHandler {

    private final TokenService tokenService;

    public LogoutService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, @Nullable Authentication authentication) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        String refreshToken = authHeader.substring(7);
        Token storeToken = tokenService.findTokenByToken(refreshToken);
        if (storeToken != null) {
            tokenService.revokeTokenByToken(refreshToken);
            SecurityContextHolder.clearContext();
        }
    }
}
