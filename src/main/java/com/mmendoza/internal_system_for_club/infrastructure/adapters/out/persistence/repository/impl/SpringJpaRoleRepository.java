package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.ports.out.RoleRepository;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.RoleEntityMapper;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.RoleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringJpaRoleRepository implements RoleRepository {

    private final RoleJpaRepository roleRepository;

    public SpringJpaRoleRepository(RoleJpaRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
