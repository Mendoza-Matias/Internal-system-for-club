package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum AuthenticationError {

    INVALID_CREDENTIALS("Credentials are invalid."),
    INVALID_TOKEN("Error validating refresh token.");

    private final String message;

    AuthenticationError(String message) {
        this.message = message;
    }
}
