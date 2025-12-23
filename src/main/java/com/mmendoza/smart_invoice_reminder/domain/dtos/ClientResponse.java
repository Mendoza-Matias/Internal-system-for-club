package com.mmendoza.smart_invoice_reminder.domain.dtos;

public record ClientResponse(Long clientId, String name, String lastName, String email, String telephone,
                             String address) {
}
