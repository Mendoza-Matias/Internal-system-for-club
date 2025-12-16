package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.mapper.TokenMapper;
import com.mmendoza.smart_invoice_reminder.repository.TokenRepository;
import com.mmendoza.smart_invoice_reminder.service.TokenService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;


    public TokenServiceImpl(TokenRepository tokenRepository, TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    @Transactional
    public void saveUserToken(String token, User user) {

        Token newToken = tokenMapper.toToken(token, user);

        tokenRepository.save(newToken);
    }

    @Override
    public Optional<Token> getTokenWithToken(String token) {
        return tokenRepository.getTokenWithToken(token);
    }

    @Override
    public List<Token> getAllValidTokensOfAUser(Long userId) {
        return tokenRepository.getAllValidTokensOfAUser(userId);
    }

    @Override
    public void revokeAllOfAUserTokens(Long userId) {
        tokenRepository.revokeAllOfAUserTokens(userId);
    }

    @Override
    public void revokeTokenWithToken(String token) {
        tokenRepository.revokeTokenWithToken(token);
    }


}
