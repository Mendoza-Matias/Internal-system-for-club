package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.mapper.TokenMapper;
import com.mmendoza.smart_invoice_reminder.repository.TokenRepository;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    private static final String TOKEN_NOT_FOUND = "Token not found";

    public TokenServiceImpl(TokenRepository tokenRepository, TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    @Transactional
    public void saveUserToken(String token, User user) {
        Token newToken = Token.builder()
                .token(token)
                .user(user)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(newToken);
    }

    @Override
    public Token findTokenByToken(String token) {
        return tokenRepository.findByToken(token).orElseThrow(() -> new ResourceNotFoundException(TOKEN_NOT_FOUND));
    }

    @Override
    public List<Token> findAllValidTokenByUser(Long userId) {
        return tokenRepository.findAllValidTokenByUser(userId);
    }

    @Override
    @Transactional
    public void revokeAllTokensByUser(Long userId) {
        tokenRepository.revokeAllTokensByUser(userId);
    }

    @Override
    @Transactional
    public void revokeTokenByToken(String token) {
        tokenRepository.revokeByToken(token);
    }
}
