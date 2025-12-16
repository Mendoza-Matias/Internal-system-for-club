package com.mmendoza.smart_invoice_reminder.service;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.dtos.CreateUserRequest;

import java.util.Optional;

public interface UserService {

    User createUser(CreateUserRequest request);

    Optional<User> findUserByEmail(String email);
}
