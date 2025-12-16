package com.mmendoza.smart_invoice_reminder.controller;

import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationRequest;
import com.mmendoza.smart_invoice_reminder.domain.dtos.AuthenticationResponse;
import com.mmendoza.smart_invoice_reminder.domain.dtos.RegisterRequest;
import com.mmendoza.smart_invoice_reminder.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentications")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/refresh")
    public AuthenticationResponse refresh(@RequestHeader("Authorization") String header) {
        return authService.refreshToken(header);
    }
}
