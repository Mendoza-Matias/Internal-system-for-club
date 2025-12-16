package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum LogoutError {

    TOKEN_NOT_FOUND("Token not found.");

    private final String message;

    LogoutError(String message) {
        this.message = message;
    }

}
