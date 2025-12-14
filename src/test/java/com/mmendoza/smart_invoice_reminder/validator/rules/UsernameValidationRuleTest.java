package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsernameValidationRuleTest {

    @InjectMocks
    private UsernameValidationRule usernameValidationRule;

    @Test
    void nullUsernameTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> usernameValidationRule.validate(null));
        assertEquals(UserError.USERNAME_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void emptyUsernameTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> usernameValidationRule.validate(""));
        assertEquals(UserError.USERNAME_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void usernameTooShortTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> usernameValidationRule.validate("mme"));
        assertEquals(UserError.USERNAME_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validUsernameTest() {
        assertDoesNotThrow(() -> usernameValidationRule.validate("mati"));
    }
}