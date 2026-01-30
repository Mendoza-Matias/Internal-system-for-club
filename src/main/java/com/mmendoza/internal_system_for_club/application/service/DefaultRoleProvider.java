package com.mmendoza.internal_system_for_club.application.service;

import com.mmendoza.internal_system_for_club.domain.exception.RoleNotConfiguredException;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.ports.out.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class DefaultRoleProvider {

    private final RoleRepository roleRepository;

    private static final String DEFAULT_ROLE = "USER";

    public DefaultRoleProvider(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getDefaultRole() {
        return roleRepository.findByName(DEFAULT_ROLE).orElseThrow(() -> new RoleNotConfiguredException("Default role USER not configured"));
    }
}
