package com.mmendoza.internal_system_for_club.application.usecase.user;

import com.mmendoza.internal_system_for_club.domain.exception.UserNotFoundException;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.in.GetUserByIdUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdInteractor implements GetUserByIdUseCase {

    private final UserRepository userRepository;

    public GetUserByIdInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
