package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Role;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.repository.RoleRepository;
import com.mmendoza.smart_invoice_reminder.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRolByName(String name) {
        return roleRepository.findByName(name);
    }
}
