package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceValidationRuleTest {

    @InjectMocks
    private PriceValidationRule rule;

    @Test
    void nullPriceTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(InvoiceError.PRICE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void priceEqualToZeroTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(BigDecimal.ZERO);
        });
        assertEquals(InvoiceError.PRICE_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void priceLessThanZeroTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(BigDecimal.valueOf(-20));
        });
        assertEquals(InvoiceError.PRICE_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validPriceTest() {
        assertDoesNotThrow(() -> {
            rule.validate(BigDecimal.TEN);
        });
    }

}