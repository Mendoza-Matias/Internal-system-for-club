package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.config.security.SecurityProperties;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.domain.entities.Role;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.TokenError;
import com.mmendoza.smart_invoice_reminder.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final SecurityProperties properties;

    public User buildUser(CreateUserRequest request) {

        String roleName = properties.getDefaultProps().getRole();

        Role role = roleService.getRolByName(roleName).orElseThrow(
                () -> new ResourceNotFoundException(TokenError.TOKEN_NOT_FOUND.getMessage())
        );

        return User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(List.of(role))
                .build();
    }
}

