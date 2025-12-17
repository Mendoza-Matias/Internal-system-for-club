package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.enums.TokenType;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public Token toToken(String token, User user) {
        return Token.builder()
                .token(token)
                .user(user)
                .expired(false)
                .revoked(false)
                .build();
    }
}
