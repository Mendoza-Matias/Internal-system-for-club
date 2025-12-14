package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmailValidationRuleTest {

    @InjectMocks
    private EmailValidationRule emailValidationRule;

    @Test
    void nullEmailTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            emailValidationRule.validate(null);
        });
        assertEquals(UserError.EMAIL_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void emptyEmailTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            emailValidationRule.validate("");
        });
        assertEquals(UserError.EMAIL_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void emailFormatTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            emailValidationRule.validate("a@a");
        });
        assertEquals(UserError.EMAIL_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validEmailTest() {
        assertDoesNotThrow(() -> {
            emailValidationRule.validate("example@gmail.com");
        });
    }
}