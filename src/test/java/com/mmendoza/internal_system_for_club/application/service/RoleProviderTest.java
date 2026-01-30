package com.mmendoza.internal_system_for_club.application.service;

import com.mmendoza.internal_system_for_club.domain.exception.RoleNotFoundException;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.ports.out.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoleProviderTest {

    @InjectMocks
    private RoleProvider roleProvider;

    @Mock
    private RoleRepository roleRepository;

    private Role expectedRole;

    @BeforeEach
    void setUp() {
        expectedRole = new Role(
                1L,
                "USER"
        );
    }


    @Test
    void should_return_default_role() {

        String defaultRole = "USER";
        Mockito.when(roleRepository.findByName(defaultRole)).thenReturn(Optional.of(expectedRole));

        Role result = roleProvider.getDefaultRole();

        assertEquals(expectedRole.getId(), result.getId());
        assertEquals(expectedRole.getName(), result.getName());

        Mockito.verify(roleRepository).findByName(defaultRole);
        Mockito.verifyNoMoreInteractions(roleRepository);
    }

    @Test
    void should_throw_exception_when_default_role_does_not_exist() {

        String defaultRole = "USER";
        Mockito.when(roleRepository.findByName(defaultRole)).thenReturn(Optional.empty());

        RoleNotFoundException exception = assertThrows(RoleNotFoundException.class, () -> roleProvider.getDefaultRole());

        assertEquals("Default role USER not configured", exception.getMessage());

        Mockito.verify(roleRepository).findByName(defaultRole);
        Mockito.verifyNoMoreInteractions(roleRepository);
    }
}