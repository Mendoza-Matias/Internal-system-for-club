package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class TelephoneValidationRule {

    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("^(\\+54\\s?)?(9\\s?)?(\\(0\\))?(\\d{2,3})\\s?\\d{4,8}$");

    public void validate(String telephone) {
        if (telephone == null || telephone.isBlank()) {
            throw new ValidationException(ClientError.TELEPHONE_REQUIRED.getMessage());
        }
        if (!hasValidFormat(telephone)) {
            throw new ValidationException(ClientError.TELEPHONE_INVALID.getMessage());
        }
    }

    private boolean hasValidFormat(String telephone) {
        return TELEPHONE_PATTERN.matcher(telephone).matches();
    }
}
