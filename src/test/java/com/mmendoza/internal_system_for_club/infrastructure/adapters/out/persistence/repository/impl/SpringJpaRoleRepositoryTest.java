package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.RoleEntityMapper;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.RoleJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpringJpaRoleRepositoryTest {

    @InjectMocks
    private SpringJpaRoleRepository repository;

    @Mock
    private RoleJpaRepository roleJpaRepository;

    @Mock
    private RoleEntityMapper roleEntityMapper;


    @Test
    void should_find_role_by_name() {

        String roleName = "ADMIN";
        Role role = new Role(1L, "ADMIN");

        Mockito.when(roleJpaRepository.findByName(roleName)).thenReturn(Optional.of(role));

        Optional<Role> result = repository.findByName(roleName);

        assertTrue(result.isPresent());
        assertEquals(roleName, result.get().getName());

        Mockito.verify(roleJpaRepository).findByName(roleName);
        Mockito.verifyNoMoreInteractions(roleJpaRepository);
    }

    @Test
    void should_return_empty_when_role_not_found() {

        String roleName = "ADMIN";

        Mockito.when(roleJpaRepository.findByName(roleName)).thenReturn(Optional.empty());

        Optional<Role> result = repository.findByName(roleName);

        assertTrue(result.isEmpty());

        Mockito.verify(roleJpaRepository).findByName(roleName);
        Mockito.verifyNoMoreInteractions(roleJpaRepository);
    }
}
