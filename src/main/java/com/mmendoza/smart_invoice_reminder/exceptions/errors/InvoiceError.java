package com.mmendoza.smart_invoice_reminder.exceptions.errors;

import lombok.Getter;

@Getter
public enum InvoiceError {

    TITLE_REQUIRED("Title required"),
    TITLE_INVALID("Title invalid"),
    DESCRIPTION_REQUIRED("Description required"),
    DESCRIPTION_INVALID("Description invalid"),
    PRICE_REQUIRED("Price required"),
    PRICE_INVALID("Price invalid"),
    PAYMENT_DEADLINE_REQUIRED("Payment deadline required"),
    PAYMENT_DEADLINE_INVALID("Payment deadline invalid"),
    PAYMENT_DEADLINE_NOT_WEEKEND("Payment deadline not weekend");

    private final String message;

    InvoiceError(String message) {
        this.message = message;
    }
}
