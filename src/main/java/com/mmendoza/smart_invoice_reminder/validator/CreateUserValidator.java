package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import com.mmendoza.smart_invoice_reminder.validator.rules.EmailValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.PasswordValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.UsernameValidationRule;
import org.springframework.stereotype.Component;

@Component
public class CreateUserValidator {

    private final UsernameValidationRule usernameValidationRule;
    private final PasswordValidationRule passwordValidationRule;
    private final EmailValidationRule emailValidationRule;

    public CreateUserValidator(UsernameValidationRule usernameValidationRule, PasswordValidationRule passwordValidationRule, EmailValidationRule emailValidationRule) {
        this.usernameValidationRule = usernameValidationRule;
        this.passwordValidationRule = passwordValidationRule;
        this.emailValidationRule = emailValidationRule;
    }

    public void validate(CreateUserRequest request) {
        if (request == null) {
            throw new ValidationException(UserError.REQUEST_REQUIRED.getMessage());
        }

        usernameValidationRule.validate(request.username());
        passwordValidationRule.validate(request.password());
        emailValidationRule.validate(request.email());
    }
}
