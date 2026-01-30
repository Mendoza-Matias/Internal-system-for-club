package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleEntityMapper {

    public Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getName());
    }

    public RoleEntity toEntity(Role role) {
        return new RoleEntity(role.getId(), role.getName());
    }

    public Set<Role> toDomainSet(Set<RoleEntity> roles) {
        return roles == null ? Collections.emptySet() : roles.stream().map(this::toDomain).collect(Collectors.toSet());
    }

    public Set<RoleEntity> toEntitySet(Set<Role> roles) {
        return roles == null ? Collections.emptySet() : roles.stream().map(this::toEntity).collect(Collectors.toSet());
    }
}
