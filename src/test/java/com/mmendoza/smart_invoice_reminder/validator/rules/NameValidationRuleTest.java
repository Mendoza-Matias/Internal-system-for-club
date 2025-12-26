package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NameValidationRuleTest {

    @InjectMocks
    private NameValidationRule rule;

    @Test
    void nullUsernameTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> rule.validate(null));
        assertEquals(ClientError.NAME_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void emptyUsernameTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> rule.validate(""));
        assertEquals(ClientError.NAME_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void usernameTooShortTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> rule.validate("te"));
        assertEquals(ClientError.NAME_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validUsernameTest() {
        assertDoesNotThrow(() -> rule.validate("test"));
    }

}