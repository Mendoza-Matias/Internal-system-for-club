package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TelephoneValidationRuleTest {

    @InjectMocks
    private TelephoneValidationRule rule;

    @Test
    void nullTelephoneTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(ClientError.TELEPHONE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void blankTelephoneTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("");
        });
        assertEquals(ClientError.TELEPHONE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void telephoneFormatTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("+551170001025");
        });
        assertEquals(ClientError.TELEPHONE_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validTelephoneTest() {
        assertDoesNotThrow(() -> {
            rule.validate("+5491170001025");
        });
    }
}