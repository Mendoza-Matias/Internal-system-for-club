package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    private static final boolean IS_EXPIRED = false;
    private static final boolean IS_REVOKED = false;

    public Token buildToken(String token, User user) {
        return Token.builder()
                .token(token)
                .user(user)
                .expired(IS_EXPIRED)
                .revoked(IS_REVOKED)
                .build();
    }
}
