package com.mmendoza.smart_invoice_reminder.exceptions;

public class ResourceExistException extends RuntimeException {
    public ResourceExistException(String message) {
        super(message);
    }
}
