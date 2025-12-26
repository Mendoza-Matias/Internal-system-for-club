package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.ClientError;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.InvoiceError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressValidationRuleTest {

    @InjectMocks
    private AddressValidationRule rule;

    @Test
    void nullAddressTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate(null);
        });
        assertEquals(ClientError.ADDRESS_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void blankAddressTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("");
        });
        assertEquals(ClientError.ADDRESS_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void validAddressTest() {
        assertDoesNotThrow(() -> {
            rule.validate("test 123");
        });
    }

}