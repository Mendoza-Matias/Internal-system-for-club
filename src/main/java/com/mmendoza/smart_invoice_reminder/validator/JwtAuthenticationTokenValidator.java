package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.config.security.JwtService;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationTokenValidator {

    private final JwtService jwtService;

    public JwtAuthenticationTokenValidator(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public boolean isValid(String token, UserDetails userDetails) {
        return jwtService.isTokenValid(token, userDetails) && jwtService.isAccessToken(token);
    }
}
