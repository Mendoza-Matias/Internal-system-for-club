package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository;

import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    boolean existsByEmail(String email);
}
