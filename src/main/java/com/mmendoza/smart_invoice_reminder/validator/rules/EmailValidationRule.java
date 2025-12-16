package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidationRule {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public void validate(String email) {
        if (email == null || email.isBlank()) {
            throw new ValidationException(UserError.EMAIL_REQUIRED.getMessage());
        }
        if (!hasValidFormat(email)) {
            throw new ValidationException(UserError.EMAIL_INVALID.getMessage());
        }
    }

    private boolean hasValidFormat(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
