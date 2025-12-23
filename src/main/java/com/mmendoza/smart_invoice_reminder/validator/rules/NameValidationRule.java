package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import org.springframework.stereotype.Component;

@Component
public class NameValidationRule {

    public void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException(ClientError.NAME_REQUIRED.getMessage());
        }
        if (name.length() < 10) {
            throw new ValidationException(ClientError.NAME_INVALID.getMessage());
        }
    }
}
