package com.mmendoza.internal.infrastructure.adapters.out.db.impl;

import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.domain.ports.out.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJpaRepository implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
