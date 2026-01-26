package com.mmendoza.internal.domain.ports.out;


import com.mmendoza.internal.domain.model.User;

public interface UserRepository {
    void save(User user);

    boolean existsByUsername(String username);
}
