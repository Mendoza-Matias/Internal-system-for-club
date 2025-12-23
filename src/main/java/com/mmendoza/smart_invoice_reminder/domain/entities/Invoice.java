package com.mmendoza.smart_invoice_reminder.domain.entities;


import com.mmendoza.smart_invoice_reminder.domain.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @Column(precision = 10, scale = 3)
    private BigDecimal price;

    private LocalDate createDate;

    private LocalDate paymentDeadline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
}
