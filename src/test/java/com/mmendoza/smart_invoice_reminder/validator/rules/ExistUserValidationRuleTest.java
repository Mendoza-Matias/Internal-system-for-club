package com.mmendoza.smart_invoice_reminder.validator.rules;

import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import com.mmendoza.smart_invoice_reminder.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExistUserValidationRuleTest {

    @InjectMocks
    private ExistUserValidationRule rule;

    @Mock
    private UserRepository repository;

    @Test
    void existUserTest() {
        Mockito.when(repository.existsByEmail(Mockito.eq("test@gmail.com"))).thenReturn(true);
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            rule.validate("test@gmail.com");
        });
        assertEquals(UserError.EMAIL_EXIST.getMessage(), exception.getMessage());
    }

    @Test
    void notExistUserTest() {
        Mockito.when(repository.existsByEmail(Mockito.eq("test@gmail.com"))).thenReturn(false);
        assertDoesNotThrow(() -> {
            rule.validate("test@gmail.com");
        });
    }

}