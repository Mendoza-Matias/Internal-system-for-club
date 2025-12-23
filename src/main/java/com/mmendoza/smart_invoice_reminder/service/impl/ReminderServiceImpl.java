package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;
import com.mmendoza.smart_invoice_reminder.service.InvoiceService;
import com.mmendoza.smart_invoice_reminder.service.NotificationService;
import com.mmendoza.smart_invoice_reminder.service.ReminderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final InvoiceService invoiceService;
    private final NotificationService notificationService;

    public ReminderServiceImpl(InvoiceService invoiceService, NotificationService notificationService) {
        this.invoiceService = invoiceService;
        this.notificationService = notificationService;
    }

    public void sendPendingInvoices() {

        LocalDate initialDate = LocalDate.now().plusDays(7);

        List<Invoice> allUnpaidInvoices =
                invoiceService.getAllUnpaidInvoices(initialDate);

        if (!allUnpaidInvoices.isEmpty()) {
            for (Invoice invoice : allUnpaidInvoices) {
                try {
                    notificationService.sendPaymentReminder(invoice);
                    invoiceService.markReminderSent(invoice.getId());
                } catch (Exception ignored) {

                }
            }
        }
    }
}
