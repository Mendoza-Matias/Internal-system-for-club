package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentDeadLineValidationRuleTest {

    @InjectMocks
    private PaymentDeadLineValidationRule rule;

    @Test
    void nullPaymentDeadLineTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(InvoiceError.PAYMENT_DEADLINE_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void validPaymentDeadLineTest() {
        assertDoesNotThrow(() -> {
            rule.validate(LocalDate.now());
        });
    }
}