package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.mapper;

import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(RegisterUserRequest request) {
        return new User(request.username(), request.email(), request.password());
    }
}
