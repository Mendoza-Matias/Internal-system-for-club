package com.mmendoza.smart_invoice_reminder.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clients")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String telephone;

    private String address;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;
}
