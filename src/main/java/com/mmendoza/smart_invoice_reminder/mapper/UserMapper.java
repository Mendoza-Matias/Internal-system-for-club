package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.config.security.SecurityProperties;
import com.mmendoza.smart_invoice_reminder.domain.entities.Role;
import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
        Role role = roleService.getRolByName(roleName);

        return User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(List.of(role))
                .build();
    }
}

