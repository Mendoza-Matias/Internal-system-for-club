package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;

import java.util.List;

public interface TokenService {
    void saveUserToken(String token, User user);

    Token findTokenByToken(String token);

    List<Token> findAllValidTokenByUser(Long userId);

    void revokeAllTokensByUser(Long userId);

    void revokeTokenByToken(String token);
}
