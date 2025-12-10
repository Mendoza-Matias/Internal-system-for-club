package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.domain.recors.RegisterRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    private static final String USERNAME_REQUIRED = "Username is required";
    private static final String EMAIL_REQUIRED = "Email is required";
    private static final String USERNAME_INVALID = "Username is invalid";
    private static final String EMAIL_INVALID = "Email is invalid";
    private static final String PASSWORD_REQUIRED = "Password is required";
    private static final String PASSWORD_INVALID = "The password is invalid";

    public void validateCreateUserRequest(CreateUserRequest request) throws ValidationException {
        if (request == null) {
            throw new ValidationException("Register data is required");
        }
        validateUsername(request.username());
        validateEmail(request.email());
        validatePassword(request.password());
    }

    private void validateUsername(String username) throws ValidationException {
        if (username == null || username.isEmpty()) {
            throw new ValidationException(USERNAME_REQUIRED);
        }
        if (username.length() < 3) {
            throw new ValidationException(USERNAME_INVALID);
        }
    }

    private void validatePassword(String password) throws ValidationException {
        if (password == null || password.isEmpty()) {
            throw new ValidationException(PASSWORD_REQUIRED);
        }
        if (password.length() < 6) {
            throw new ValidationException(PASSWORD_INVALID);
        }
    }

    public void validateEmail(String email) throws ValidationException {
        if (email == null) {
            throw new ValidationException(EMAIL_REQUIRED);
        }
        if (!email.contains("@")) {
            throw new ValidationException(EMAIL_INVALID);
        }
    }

}
