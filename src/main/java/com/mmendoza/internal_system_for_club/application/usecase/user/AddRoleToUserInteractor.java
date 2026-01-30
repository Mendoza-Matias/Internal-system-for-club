package com.mmendoza.internal_system_for_club.application.usecase.user;

import com.mmendoza.internal_system_for_club.application.service.RoleInteractor;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.in.AddRoleToUserUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddRoleToUserInteractor implements AddRoleToUserUseCase {

    private final RoleInteractor roleInteractor;
    private final UserRepository userRepository;

    public AddRoleToUserInteractor(UserRepository userRepository, RoleInteractor roleInteractor) {
        this.userRepository = userRepository;
        this.roleInteractor = roleInteractor;
    }

    @Override
    public void addRole(User user, String role) {

        Role newRole = roleInteractor.getByName(role);

        user.getRoles().add(newRole);

        userRepository.save(user);
    }
}
