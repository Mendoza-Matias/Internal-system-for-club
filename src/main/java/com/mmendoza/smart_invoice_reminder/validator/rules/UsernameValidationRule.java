package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.springframework.stereotype.Component;

@Component
public class UsernameValidationRule {

    public void validate(String username) {
        if (username == null || username.isBlank()) {
            throw new ValidationException(
                    UserError.USERNAME_REQUIRED.getMessage()
            );
        }
        if (username.length() <= 3) {
            throw new ValidationException(
                    UserError.USERNAME_INVALID.getMessage()
            );
        }
    }
}
