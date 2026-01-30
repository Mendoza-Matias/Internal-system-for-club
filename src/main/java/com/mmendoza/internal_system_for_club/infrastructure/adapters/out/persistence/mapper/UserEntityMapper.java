package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper;

import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    private final RoleEntityMapper roleEntityMapper;

    public UserEntityMapper(RoleEntityMapper roleEntityMapper) {
        this.roleEntityMapper = roleEntityMapper;
    }

    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getIsActive(),
                roleEntityMapper.toEntitySet(user.getRoles())
        );
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                roleEntityMapper.toDomainSet(userEntity.getRoles()));
    }
}
