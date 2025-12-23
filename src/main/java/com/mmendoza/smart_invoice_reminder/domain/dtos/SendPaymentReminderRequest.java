package com.mmendoza.smart_invoice_reminder.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SendPaymentReminderRequest(String name, String lastName, String email, BigDecimal amount,
                                         LocalDate dueDate) {
}
