package com.mmendoza.internal_system_for_club.application.usecase.auth;

import com.mmendoza.internal_system_for_club.application.service.RoleInteractor;
import com.mmendoza.internal_system_for_club.domain.exception.UserExistingException;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.in.RegisterUserUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.out.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegisterUserInteractor implements RegisterUserUseCase {

    private final UserRepository userRepository;
    private final RoleInteractor roleInteractor;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserInteractor(UserRepository userRepository, RoleInteractor roleInteractor, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleInteractor = roleInteractor;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserExistingException("User already exists");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        Role defaultRole = roleInteractor.getByName("USER");

        User user = User.create(
                request.getUsername(),
                request.getEmail(),
                hashedPassword,
                Set.of(defaultRole)
        );

        userRepository.save(user);
    }
}
