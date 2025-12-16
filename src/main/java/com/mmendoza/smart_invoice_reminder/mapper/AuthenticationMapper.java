package com.mmendoza.smart_invoice_reminder.mapper;


import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {

    public CreateUserRequest toCreateUserRequest(RegisterRequest request) {
        return new CreateUserRequest(request.username(), request.email(), request.password());
    }

    public AuthenticationResponse toAuthenticationResponse(String jwt, String refreshToken) {
        return new AuthenticationResponse(jwt, refreshToken);
    }
}
