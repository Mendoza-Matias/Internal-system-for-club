package com.mmendoza.internal.infrastructure.adapters.in.mapper;

import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(RegisterUserRequest request) {
        return new User(request.username(), request.email(), request.password());
    }
}
