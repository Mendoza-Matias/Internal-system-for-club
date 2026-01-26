package com.mmendoza.internal.infrastructure.adapters.in.mapper;

import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper;

    private RegisterUserRequest request;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
        request = new RegisterUserRequest("username", "email", "password");
    }

    @Test
    void map_to_domain_user() {
        User domain = userMapper.toDomain(request);

        assertNotNull(domain);
        assertEquals("username", domain.getUsername());
        assertEquals("email", domain.getEmail());
        assertEquals("password", domain.getPassword());
    }
}
