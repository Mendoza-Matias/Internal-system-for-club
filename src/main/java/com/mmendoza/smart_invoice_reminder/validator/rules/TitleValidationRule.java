package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.springframework.stereotype.Component;

@Component
public class TitleValidationRule {

    public void validate(String title) {
        if (title == null || title.isBlank()) {
            throw new ValidationException(InvoiceError.TITLE_REQUIRED.getMessage());
        }
    }
}
