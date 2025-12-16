package com.mmendoza.smart_invoice_reminder.repository;

import com.mmendoza.smart_invoice_reminder.domain.entities.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.token = :token")
    Optional<Token> getTokenWithToken(String token);

    @Query("SELECT t FROM Token t WHERE not t.expired and not t.revoked and t.user.id = :userId")
    List<Token> getAllValidTokensOfAUser(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Token t SET t.expired = true, t.revoked = true WHERE t.user.id = :userId")
    void revokeAllOfAUserTokens(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Token  t SET t.expired= true, t.revoked=true WHERE t.token = :token")
    void revokeTokenWithToken(@Param("token") String token);
}
