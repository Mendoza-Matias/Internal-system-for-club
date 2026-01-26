package com.mmendoza.internal.infrastructure.adapters.in.http;

import com.mmendoza.internal.application.service.user.RegisterUserService;
import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import com.mmendoza.internal.infrastructure.adapters.in.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //Use cases
    private final RegisterUserService registerUserService;

    private final UserMapper userMapper;

    public UserController(RegisterUserService registerUserService, UserMapper userMapper) {
        this.registerUserService = registerUserService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {

        User user = userMapper.toDomain(registerUserRequest);

        registerUserService.register(user);

        return ResponseEntity.created(URI.create("/api/v1/users")).build();
    }
}
