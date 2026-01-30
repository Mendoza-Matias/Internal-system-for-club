package com.mmendoza.internal_system_for_club.domain.ports.in;

import com.mmendoza.internal_system_for_club.domain.model.User;

import java.util.Optional;

public interface GetUserByIdUseCase {
    User findById(Long id);
}
