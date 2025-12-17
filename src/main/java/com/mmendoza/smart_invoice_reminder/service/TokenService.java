package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface TokenService {

    void saveUserToken(String token, User user);

    List<Token> getAllValidTokensOfAUser(Long userId);

    void revokeAllOfAUserTokens(Long userId);

    void revokeTokenWithToken(String token);
}
