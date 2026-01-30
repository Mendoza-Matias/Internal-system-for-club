package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.ports.out.RoleRepository;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.RoleEntity;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.RoleEntityMapper;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.RoleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SpringJpaRoleRepository implements RoleRepository {

    private final RoleJpaRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    public SpringJpaRoleRepository(RoleJpaRepository roleRepository, RoleEntityMapper roleEntityMapper, RoleEntityMapper roleEntityMapper1) {
        this.roleRepository = roleRepository;
        this.roleEntityMapper = roleEntityMapper1;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name).map(roleEntityMapper::toDomain);
    }
}
