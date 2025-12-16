package com.mmendoza.smart_invoice_reminder.domain.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "roles")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
