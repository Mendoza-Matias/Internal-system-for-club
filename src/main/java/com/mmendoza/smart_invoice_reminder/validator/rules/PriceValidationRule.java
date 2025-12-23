package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceValidationRule {

    public void validate(BigDecimal price) {
        if (price == null) {
            throw new ValidationException(InvoiceError.PRICE_REQUIRED.getMessage());
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException(InvoiceError.PRICE_INVALID.getMessage());
        }
    }

}
