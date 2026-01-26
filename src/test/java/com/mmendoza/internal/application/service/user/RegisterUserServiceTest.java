package com.mmendoza.internal.application.service.user;

import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.domain.ports.out.UserRepository;
import com.mmendoza.internal.infrastructure.adapters.in.dto.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegisterUserServiceTest {

    @InjectMocks
    private RegisterUserService registerUserService;

    @Mock
    private UserRepository userRepository;

    private User request;

    @BeforeEach
    void setUp() {
        request = new User("username", "email", "password");
    }

    @Test
    void correct_register() {
        registerUserService.register(request);

        Mockito.verify(userRepository).save(Mockito.any(User.class));
    }
}