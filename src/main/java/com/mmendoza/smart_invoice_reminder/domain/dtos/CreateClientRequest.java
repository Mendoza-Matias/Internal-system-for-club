package com.mmendoza.smart_invoice_reminder.domain.dtos;

public record CreateClientRequest(String name, String lastName, String email, String telephone, String address) {
}
