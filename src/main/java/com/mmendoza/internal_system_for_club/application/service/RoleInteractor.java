package com.mmendoza.internal_system_for_club.application.service;

import com.mmendoza.internal_system_for_club.domain.exception.RoleNotFoundException;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.ports.out.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleInteractor {

    private final RoleRepository roleRepository;

    public RoleInteractor(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RoleNotFoundException(name));
    }
}

