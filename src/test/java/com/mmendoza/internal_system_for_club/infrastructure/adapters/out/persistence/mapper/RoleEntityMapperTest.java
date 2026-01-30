package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.RoleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleEntityMapperTest {

    private RoleEntityMapper roleEntityMapper;

    private RoleEntity roleEntity;

    private Role role;

    @BeforeEach
    void setUp() {
        roleEntityMapper = new RoleEntityMapper();
        roleEntity = new RoleEntity(
                1L,
                "EMPLOYEE"
        );
        role = new Role(
                1L,
                "EMPLOYEE"
        );
    }

    @Test
    void should_return_role_domain() {
        Role result = roleEntityMapper.toDomain(roleEntity);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("EMPLOYEE", result.getName());
    }

    @Test
    void should_return_role_entity() {
        RoleEntity result = roleEntityMapper.toEntity(role);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("EMPLOYEE", result.getName());
    }

    @Test
    public void should_return_role_domain_list() {
        Set<Role> result = roleEntityMapper.toDomainSet(Set.of(roleEntity));

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void should_return_role_entity_list() {
        Set<RoleEntity> result = roleEntityMapper.toEntitySet(Set.of(role));

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}