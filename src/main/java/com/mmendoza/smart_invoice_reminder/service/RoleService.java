package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.Role;

public interface RoleService {
    Role getRolByName(String name);
}
