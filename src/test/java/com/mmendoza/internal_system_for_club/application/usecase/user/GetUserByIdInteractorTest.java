package com.mmendoza.internal_system_for_club.application.usecase.user;

import com.mmendoza.internal_system_for_club.domain.exception.UserNotFoundException;
import com.mmendoza.internal_system_for_club.domain.model.Role;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.out.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetUserByIdInteractorTest {

    @InjectMocks
    private GetUserByIdInteractor interactor;

    @Mock
    private UserRepository userRepository;

    private User expectedUser;

    @BeforeEach
    void setUp() {
        expectedUser = new User(
                1L,
                "Matias",
                "mendoza@gmail.com",
                "password",
                Set.of(new Role(1L, "USER"))
        );
    }

    @Test
    void should_return_user_when_user_exists() {

        Long userId = 1L;
        Mockito.when(userRepository.getUserById(userId)).thenReturn(Optional.of(expectedUser));

        User result = interactor.findById(userId);

        assertNotNull(result);
        assertEquals(expectedUser.getId(), result.getId());
        assertEquals(expectedUser.getEmail(), result.getEmail());

        Mockito.verify(userRepository).getUserById(userId);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    void should_throw_exception_when_user_does_not_exist() {

        Long userId = 1L;
        Mockito.when(userRepository.getUserById(userId)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> interactor.findById(userId));

        assertEquals("User not found", exception.getMessage());

        Mockito.verify(userRepository).getUserById(userId);
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}
