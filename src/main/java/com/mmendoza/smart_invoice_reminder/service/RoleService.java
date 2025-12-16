package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> getRolByName(String name);

}
