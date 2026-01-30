package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.RoleEntity;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserEntityMapperTest {

    private UserEntityMapper userEntityMapper;

    private RoleEntityMapper roleEntityMapper;

    private UserEntity userEntity;

    private User user;

    @BeforeEach
    void setUp() {
        roleEntityMapper = new RoleEntityMapper();
        userEntityMapper = new UserEntityMapper(roleEntityMapper);

        user = new User(
                1L,
                "username",
                "email",
                "password",
                Set.of(
                        new Role(
                                1L,
                                "USER"
                        )
                ));

        userEntity = new UserEntity(
                1L,
                "username",
                "email",
                "password",
                true,
                Set.of(
                        new RoleEntity(
                                1L,
                                "USER"
                        )
                )
        );
    }

    @Test
    void should_return_user_entity() {
        UserEntity result = userEntityMapper.toEntity(user);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("email", result.getEmail());
        assertEquals("password", result.getPassword());
        assertTrue(result.isActive());
        assertEquals(1, result.getRoles().size());
    }

    @Test
    void should_return_user_domain() {
        User result = userEntityMapper.toDomain(userEntity);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("email", result.getEmail());
        assertEquals("password", result.getPassword());
        assertTrue(result.getIsActive());
        assertEquals(1, result.getRoles().size());
    }
}