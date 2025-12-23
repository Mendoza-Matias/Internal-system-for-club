package com.mmendoza.smart_invoice_reminder.config.scheduler;

import com.mmendoza.smart_invoice_reminder.service.ReminderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PaymentReminderScheduler {

    private final ReminderService reminderService;

    public PaymentReminderScheduler(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void run() {
        reminderService.sendPendingInvoices();
    }

}

