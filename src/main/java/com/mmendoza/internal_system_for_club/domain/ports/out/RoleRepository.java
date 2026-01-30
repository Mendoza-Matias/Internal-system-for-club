package com.mmendoza.internal_system_for_club.domain.ports.out;

import com.mmendoza.internal_system_for_club.domain.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
