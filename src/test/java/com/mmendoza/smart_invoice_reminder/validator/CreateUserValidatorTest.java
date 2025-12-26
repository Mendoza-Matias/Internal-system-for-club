package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import com.mmendoza.smart_invoice_reminder.validator.rules.EmailValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.ExistUserValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.PasswordValidationRule;
import com.mmendoza.smart_invoice_reminder.validator.rules.UsernameValidationRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserValidatorTest {

    @InjectMocks
    private CreateUserValidator createUserValidator;

    @Mock
    private UsernameValidationRule usernameValidationRule;

    @Mock
    private EmailValidationRule emailValidationRule;

    @Mock
    private PasswordValidationRule passwordValidationRule;

    @Mock
    private ExistUserValidationRule existUserValidationRule;

    private CreateUserRequest request;

    @BeforeEach
    void setUp() {
        request = new CreateUserRequest("test", "test@gmail.com", "TestPassword$01");
    }

    @Test
    void requestNullTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> createUserValidator.validate(null));
        assertEquals(UserError.REQUEST_REQUIRED.getMessage(), exception.getMessage());
    }

    @Test
    void validRequestTest() {
        assertDoesNotThrow(() -> {
            createUserValidator.validate(request);
        });
    }

    @Test
    void validateCallToRuleMethodsTest() {
        createUserValidator.validate(request);

        Mockito.verify(usernameValidationRule).validate(Mockito.eq("test"));
        Mockito.verify(emailValidationRule).validate(Mockito.eq("test@gmail.com"));
        Mockito.verify(passwordValidationRule).validate(Mockito.eq("TestPassword$01"));
        Mockito.verify(existUserValidationRule).validate(Mockito.eq("test@gmail.com"));
    }


}

