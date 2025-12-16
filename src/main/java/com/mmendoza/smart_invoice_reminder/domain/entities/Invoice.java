package com.mmendoza.smart_invoice_reminder.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "invoices")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Boolean isPayment;
    private LocalDate createDate;
    private LocalDate paymentDeadline;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
}
