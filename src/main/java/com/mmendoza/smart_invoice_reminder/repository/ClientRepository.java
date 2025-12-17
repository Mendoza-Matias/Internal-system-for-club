package com.mmendoza.smart_invoice_reminder.repository;

import com.mmendoza.smart_invoice_reminder.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
