package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.mapper;

import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper;

    private RegisterUserRequest request;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
        request = new RegisterUserRequest(
                "username",
                "email",
                "password"
        );
    }

    @Test
    void should_return_user_domain() {
        User result = userMapper.toDomain(request);

        assertNotNull(result);
        assertEquals("username", result.getUsername());
        assertEquals("email", result.getEmail());
        assertEquals("password", result.getPassword());
    }
}
