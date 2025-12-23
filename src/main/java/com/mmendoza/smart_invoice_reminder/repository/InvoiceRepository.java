package com.mmendoza.smart_invoice_reminder.repository;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT i FROM Invoice i WHERE i.paymentDeadline = :dueDate AND i.status = 'PENDING'")
    List<Invoice> getAllUnpaidInvoicesWithOneWeekDue(@Param("dueDate") LocalDate date);

    @Modifying
    @Transactional
    @Query("UPDATE Invoice i SET i.status = 'PAID' WHERE i.id = :invoiceId")
    void markReminderSent(@Param("invoiceId") Long invoiceId);
}
