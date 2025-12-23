package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum ClientError {

    CLIENT_NOT_FOUND("Client not found"),
    NAME_REQUIRED("Name required"),
    NAME_INVALID("Name invalid"),
    TELEPHONE_REQUIRED("Telephone required"),
    TELEPHONE_INVALID("Telephone invalid"),
    ADDRESS_REQUIRED("Address required");

    private final String message;

    ClientError(String message) {
        this.message = message;
    }
}
