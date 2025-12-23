package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.springframework.stereotype.Component;

@Component
public class DescriptionValidationRule {

    public void validate(String description) {
        if (description == null || description.isBlank()) {
            throw new ValidationException(InvoiceError.DESCRIPTION_REQUIRED.getMessage());
        }
    }

}
