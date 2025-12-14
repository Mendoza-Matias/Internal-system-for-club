package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordValidationRuleTest {

    @InjectMocks
    private PasswordValidationRule passwordValidationRule;

    @Test
    void nullPassword() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            passwordValidationRule.validate(null);
        });
        assertEquals(UserError.PASSWORD_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void emptyPassword() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            passwordValidationRule.validate("");
        });
        assertEquals(UserError.PASSWORD_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void passwordFormatTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            passwordValidationRule.validate("123");
        });
        assertEquals(UserError.PASSWORD_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validPassword() {
        assertDoesNotThrow(() -> {
            passwordValidationRule.validate("MyPassw0rd$");
        });
    }
}