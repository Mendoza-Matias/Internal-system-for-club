package com.mmendoza.internal_system_for_club.domain.ports.out;

import com.mmendoza.internal_system_for_club.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
