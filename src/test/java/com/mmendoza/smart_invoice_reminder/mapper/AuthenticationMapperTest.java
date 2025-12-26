package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationMapperTest {

    @InjectMocks
    private AuthenticationMapper authenticationMapper;

    @Test
    void toCreateUserRequestTest() {
        CreateUserRequest result = authenticationMapper.toCreateUserRequest(new RegisterRequest("test", "test@gmail.com", "TestPassword$01"));
        assertNotNull(result);
        assertEquals(CreateUserRequest.class, result.getClass());
    }

    @Test
    void toAuthenticationResponseTest() {
        AuthenticationResponse result = authenticationMapper.toAuthenticationResponse("jwt", "refreshToken");
        assertNotNull(result);
        assertEquals(AuthenticationResponse.class, result.getClass());

    }
}