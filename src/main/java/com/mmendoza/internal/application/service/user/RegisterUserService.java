package com.mmendoza.internal.application.service.user;

import com.mmendoza.internal.domain.ports.in.RegisterUserUseCase;
import com.mmendoza.internal.domain.model.User;
import com.mmendoza.internal.domain.ports.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User request) {

        User user = User.create(request.getUsername(), request.getEmail(), request.getPassword());

        userRepository.save(user);
    }
}
