package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import org.springframework.stereotype.Component;

@Component
public class AddressValidationRule {

    public void validate(String address) {
        if (address == null || address.isBlank()) {
            throw new ValidationException(ClientError.ADDRESS_REQUIRED.getMessage());
        }
    }
}
