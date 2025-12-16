package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Role;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.exceptions.errors.RoleError;
import com.mmendoza.smart_invoice_reminder.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    @Test
    void getRoleByNameTest() {

        Mockito.when(roleRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(Role.builder().name("USER").build()));

        Optional<Role> role = roleService.getRolByName("USER");

        assertEquals("USER", role.get().getName());
    }
}