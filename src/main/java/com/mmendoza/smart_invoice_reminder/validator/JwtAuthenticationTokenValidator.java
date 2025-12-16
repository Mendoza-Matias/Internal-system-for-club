package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.config.security.JwtService;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationTokenValidator {

    private final JwtService jwtService;
    private final TokenService tokenService;

    public JwtAuthenticationTokenValidator(JwtService jwtService, TokenService tokenService) {
        this.jwtService = jwtService;
        this.tokenService = tokenService;
    }

    public boolean isValid(String token, UserDetails userDetails) {
        boolean jwtValid = jwtService.isTokenValid(token, userDetails);

        boolean storedTokenValid = tokenService.getTokenWithToken(token)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);

        return jwtValid && storedTokenValid;
    }
}
