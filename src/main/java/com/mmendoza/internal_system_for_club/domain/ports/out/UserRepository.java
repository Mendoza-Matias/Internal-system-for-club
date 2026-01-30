package com.mmendoza.internal_system_for_club.domain.ports.out;


import com.mmendoza.internal_system_for_club.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> getUserById(Long userId);

    Optional<User> getUserByUsername(String username);

    boolean existsByEmail(String email);
}
