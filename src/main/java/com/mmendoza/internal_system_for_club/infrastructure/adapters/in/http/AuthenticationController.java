package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.http;

import com.mmendoza.internal_system_for_club.application.usecase.auth.AuthenticateUserInteractor;
import com.mmendoza.internal_system_for_club.application.usecase.auth.RegisterUserInteractor;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.AuthenticationRequest;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.response.AuthenticationResponse;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.mapper.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/authentications")
@Tag(name = "Authentication", description = "Api of authentication")
public class AuthenticationController {

    private final RegisterUserInteractor registerUserInteractor;
    private final AuthenticateUserInteractor authenticateUserInteractor;

    private final UserMapper userMapper;

    public AuthenticationController(RegisterUserInteractor registerUserInteractor, AuthenticateUserInteractor authenticateUserInteractor, UserMapper userMapper) {
        this.registerUserInteractor = registerUserInteractor;
        this.authenticateUserInteractor = authenticateUserInteractor;
        this.userMapper = userMapper;
    }


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserRequest registerUserRequest) {

        User user = userMapper.toDomain(registerUserRequest);

        registerUserInteractor.register(user);

        return ResponseEntity.created(URI.create("/api/v1/users")).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {

        String jwt = authenticateUserInteractor.login(authenticationRequest.username(), authenticationRequest.password());

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
