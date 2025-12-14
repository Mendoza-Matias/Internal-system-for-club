package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordValidationRule {

    /*
     At least 8 characters
     At least one uppercase letter
     At least one lowercase letter
     At least one digit
     At least one special character
     */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    public void validate(String password) {
        if (password == null || password.isBlank()) {
            throw new ValidationException(UserError.PASSWORD_REQUIRED.getMessage());
        }
        if (!hasValidFormat(password)) {
            throw new ValidationException(UserError.PASSWORD_INVALID.getMessage());
        }
    }

    private boolean hasValidFormat(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
