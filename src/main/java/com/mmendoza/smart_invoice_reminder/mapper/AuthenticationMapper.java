package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.domain.recors.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {

    public CreateUserRequest buildCreateUserRequest(RegisterRequest request) {
        return new CreateUserRequest(request.username(), request.email(), request.password());
    }

    public AuthenticationResponse buildAuthenticationResponse(String jwt, String refreshToken) {
        return new AuthenticationResponse(jwt, refreshToken);
    }
}
