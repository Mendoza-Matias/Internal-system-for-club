package com.mmendoza.smart_invoice_reminder.service.impl;

import com.mmendoza.smart_invoice_reminder.domain.entities.User;
import com.mmendoza.smart_invoice_reminder.domain.recors.CreateUserRequest;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceExistException;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.mapper.UserMapper;
import com.mmendoza.smart_invoice_reminder.repository.UserRepository;
import com.mmendoza.smart_invoice_reminder.service.UserService;
import com.mmendoza.smart_invoice_reminder.validator.UserValidation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidation userValidation;
    private final UserMapper userMapper;

    private static final String USER_NOT_FOUND = "User not found";
    private static final String USER_ALREADY_EXISTS = "User already exists";


    public UserServiceImpl(UserRepository userRepository, UserValidation userValidation, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(CreateUserRequest request) {
        if (existByEmail(request.email()))
            throw new ResourceExistException(USER_ALREADY_EXISTS);
        userValidation.validateCreateUserRequest(request);
        return userRepository.save(userMapper.buildUser(request));
    }

    @Override
    public User findUserByEmail(String email) {
        userValidation.validateEmail(email);
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    private boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}

