package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum UserError {
    REQUEST_REQUIRED("The request is required."),
    USERNAME_REQUIRED("Username is required."),
    USERNAME_INVALID("The username is invalid."),
    EMAIL_REQUIRED("Email is required."),
    EMAIL_INVALID("The format of the email is invalid."),
    PASSWORD_REQUIRED("Password is required."),
    PASSWORD_INVALID("The format of the password is invalid.");

    private final String message;

    UserError(String message) {
        this.message = message;
    }
}

