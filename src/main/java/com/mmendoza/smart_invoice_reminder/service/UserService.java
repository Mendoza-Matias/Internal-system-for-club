package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;

public interface UserService {
    User createUser(CreateUserRequest request);

    User findUserByEmail(String email);
}
