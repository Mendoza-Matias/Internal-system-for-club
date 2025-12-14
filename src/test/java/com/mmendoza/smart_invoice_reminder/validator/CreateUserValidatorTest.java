package com.mmendoza.smart_invoice_reminder.validator;

import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.UserError;
import com.mmendoza.smart_invoice_reminder.validator.rules.EmailValidationRule;
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

    private CreateUserRequest request;

    @BeforeEach
    void setUp() {
        request = new CreateUserRequest("example", "example@gmail.com", "Pass$Example01");
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
    void validateTheExceptionOfARuleMethodTest() {
        CreateUserRequest request =
                new CreateUserRequest("bad", "email.example@gmail.com", "Pass$Example01");

        Mockito.doThrow(new ValidationException(UserError.USERNAME_INVALID.getMessage()))
                .when(usernameValidationRule).validate("bad");

        ValidationException exception =
                assertThrows(ValidationException.class, () -> createUserValidator.validate(request));

        assertEquals(UserError.USERNAME_INVALID.getMessage(), exception.getMessage());
    }

    @Test
    void validateCallToRuleMethodsTest() {
        createUserValidator.validate(request);

        Mockito.verify(usernameValidationRule).validate(Mockito.eq("example"));
        Mockito.verify(emailValidationRule).validate(Mockito.eq("example@gmail.com"));
        Mockito.verify(passwordValidationRule).validate(Mockito.eq("Pass$Example01"));
    }


}

