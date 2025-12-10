package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.Role;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.repository.RoleRepository;
import com.mmendoza.smart_invoice_reminder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final static String ROLE_NOT_FOUND = "Role not found";

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRolByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(ROLE_NOT_FOUND));
    }
}
