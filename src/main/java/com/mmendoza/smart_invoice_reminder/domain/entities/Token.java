package com.mmendoza.smart_invoice_reminder.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tokens")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private boolean revoked;

    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
