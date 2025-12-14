package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.mapper.UserMapper;
import com.mmendoza.smart_invoice_reminder.repository.UserRepository;
import com.mmendoza.smart_invoice_reminder.service.UserService;
import com.mmendoza.smart_invoice_reminder.validator.CreateUserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CreateUserValidator createUserValidator;
    private final UserMapper mapper;


    @Override
    public User createUser(CreateUserRequest request) {
        createUserValidator.validate(request);
        return repository.save(mapper.buildUser(request));
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }
}