package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DescriptionValidationRuleTest {

    @InjectMocks
    private DescriptionValidationRule rule;

    @Test
    void nullDescriptionTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(InvoiceError.DESCRIPTION_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void blankDescriptionTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("");
        });
        assertEquals(InvoiceError.DESCRIPTION_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void validDescriptionTest() {
        assertDoesNotThrow(() -> {
            rule.validate("test");
        });
    }

}