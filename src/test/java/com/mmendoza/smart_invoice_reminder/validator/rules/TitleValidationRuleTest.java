package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TitleValidationRuleTest {

    @InjectMocks
    private TitleValidationRule rule;

    @Test
    void nullTitleTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(InvoiceError.TITLE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void blankTitleTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("");
        });
        assertEquals(InvoiceError.TITLE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void validTitleTest() {
        assertDoesNotThrow(() -> rule.validate("test"));
    }
}