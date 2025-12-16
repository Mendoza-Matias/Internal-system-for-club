package com.mmendoza.smart_invoice_reminder.service;


import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.RegisterRequest;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(String oldRefreshToken);
}
