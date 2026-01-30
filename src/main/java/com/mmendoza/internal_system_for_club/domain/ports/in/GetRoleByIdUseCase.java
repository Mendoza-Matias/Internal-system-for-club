package com.mmendoza.internal_system_for_club.domain.ports.in;

import com.mmendoza.internal_system_for_club.domain.model.Role;

import java.util.Optional;

public interface GetRoleByIdUseCase {
    Optional<Role> findById(Long id);
}
