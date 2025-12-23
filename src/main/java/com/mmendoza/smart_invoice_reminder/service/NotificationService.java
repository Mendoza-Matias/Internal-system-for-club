package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.dtos.SendPaymentReminderRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Invoice;

public interface NotificationService {
    void sendPaymentReminder(Invoice invoice);
}
