package com.mmendoza.internal_system_for_club.application.usecase.auth;

import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.security.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticateUserInteractorTest {

    @InjectMocks
    private AuthenticateUserInteractor authenticateUserInteractor;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtService jwtService;

    @Test
    void validate_arguments_of_login() {
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null);

        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);

        Mockito.when(jwtService.generate(Mockito.any())).thenReturn("token");

        ArgumentCaptor<UsernamePasswordAuthenticationToken> captor = ArgumentCaptor.forClass(UsernamePasswordAuthenticationToken.class);

        authenticateUserInteractor.login("username", "password");

        Mockito.verify(authenticationManager).authenticate(captor.capture());

        UsernamePasswordAuthenticationToken token = captor.getValue();

        assertEquals("username", token.getPrincipal());
        assertEquals("password", token.getCredentials());
    }

    @Test
    void successful_to_login() {
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null);

        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);

        Mockito.when(jwtService.generate(userDetails)).thenReturn("token");

        String jwt = authenticateUserInteractor.login("username", "password");

        assertEquals("token", jwt);

        Mockito.verify(jwtService).generate(userDetails);
    }
}