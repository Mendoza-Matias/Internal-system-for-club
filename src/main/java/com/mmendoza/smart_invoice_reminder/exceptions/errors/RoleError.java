package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum RoleError {

    ROLE_NOT_FOUND("Role not found.");

    private final String message;

    RoleError(String message) {
        this.message = message;
    }
}
