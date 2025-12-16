package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import com.mmendoza.smart_invoice_reminder.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ExistUserValidationRule {

    private final UserRepository userRepository;

    public ExistUserValidationRule(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ValidationException(UserError.EMAIL_EXIST.getMessage());
        }
    }
}
