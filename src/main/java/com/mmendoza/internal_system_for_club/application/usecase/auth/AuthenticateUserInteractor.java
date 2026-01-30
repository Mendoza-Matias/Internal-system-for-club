package com.mmendoza.internal_system_for_club.application.usecase.auth;

import com.mmendoza.internal_system_for_club.domain.ports.in.AuthenticateUserUseCase;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateUserInteractor implements AuthenticateUserUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticateUserInteractor(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public String login(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username,
                password
        ));
        return jwtService.generate((UserDetails) authenticate.getPrincipal());
    }
}
