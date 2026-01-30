package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.out.UserRepository;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.UserJpaRepository;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.UserEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringJpaUserRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public SpringJpaUserRepository(UserJpaRepository userJpaRepository, UserEntityMapper userEntityMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userJpaRepository.findById(userId).map(userEntityMapper::toDomain);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userJpaRepository.findByUsername(username).map(userEntityMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
