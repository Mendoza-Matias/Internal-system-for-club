package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateInvoiceForAnClientRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    void createInvoiceForAnClient(CreateInvoiceForAnClientRequest request);

    List<Invoice> getAllUnpaidInvoices(LocalDate date);

    void markReminderSent(Long invoiceId);
}
