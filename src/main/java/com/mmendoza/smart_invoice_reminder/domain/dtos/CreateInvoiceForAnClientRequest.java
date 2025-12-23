package com.mmendoza.smart_invoice_reminder.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInvoiceForAnClientRequest(
        Long clientId,
        String title,
        String description,
        BigDecimal price,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate paymentDeadline
) {
}
