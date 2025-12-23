package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class TelephoneValidationRule {

    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("/(?<=\\s|:)\\(?(?:(0?[1-3]\\d{1,2})\\)?(?:\\s|-)?)?((?:\\d[\\d-]{5}|15[\\s\\d-]{7})\\d+)/");

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
