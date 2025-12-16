package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum TokenError {

    TOKEN_NOT_FOUND("Token not found.");

    private String message;

    TokenError(String message) {
        this.message = message;
    }
}
