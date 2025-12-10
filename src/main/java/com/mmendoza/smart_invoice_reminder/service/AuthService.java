package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.recors.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.recors.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}
