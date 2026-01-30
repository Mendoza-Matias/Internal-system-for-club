package com.mmendoza.internal_system_for_club.domain.ports.in;

import com.mmendoza.internal_system_for_club.domain.model.User;

public interface AddRoleToUserUseCase {
    void addRole(User user, String role);
}
