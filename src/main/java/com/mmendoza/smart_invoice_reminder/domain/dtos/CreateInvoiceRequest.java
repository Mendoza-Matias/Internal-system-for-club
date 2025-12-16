package com.mmendoza.smart_invoice_reminder.domain.dtos;

public record CreateInvoiceRequest(String title, String description, Double price, Boolean isPayment) {
}
