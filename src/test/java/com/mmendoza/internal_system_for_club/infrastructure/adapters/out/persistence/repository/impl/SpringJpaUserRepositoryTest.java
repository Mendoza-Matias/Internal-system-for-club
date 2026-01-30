package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.UserEntityMapper;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpringJpaUserRepositoryTest {

    @InjectMocks
    private SpringJpaUserRepository repository;

    @Mock
    private UserJpaRepository userJpaRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @Test
    void should_save_user() {
        User user = Mockito.mock(User.class);
        UserEntity entity = Mockito.mock(UserEntity.class);

        Mockito.when(userEntityMapper.toUserEntity(user)).thenReturn(entity);

        repository.save(user);

        Mockito.verify(userEntityMapper).toUserEntity(user);
        Mockito.verify(userJpaRepository).save(entity);
        Mockito.verifyNoMoreInteractions(userJpaRepository, userEntityMapper);
    }

    @Test
    void should_get_user_by_id() {
        Long id = 1L;
        UserEntity entity = Mockito.mock(UserEntity.class);
        User user = Mockito.mock(User.class);

        Mockito.when(userJpaRepository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.when(userEntityMapper.toDomain(entity)).thenReturn(user);

        Optional<User> result = repository.getUserById(id);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());

        Mockito.verify(userJpaRepository).findById(id);
        Mockito.verify(userEntityMapper).toDomain(entity);
        Mockito.verifyNoMoreInteractions(userJpaRepository, userEntityMapper);
    }

    @Test
    void should_return_empty_when_user_not_found_by_id() {
        Long id = 1L;

        Mockito.when(userJpaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<User> result = repository.getUserById(id);

        assertTrue(result.isEmpty());

        Mockito.verify(userJpaRepository).findById(id);
        Mockito.verifyNoMoreInteractions(userJpaRepository, userEntityMapper);
    }

    @Test
    void should_get_user_by_username() {
        String username = "user";
        UserEntity entity = Mockito.mock(UserEntity.class);
        User user = Mockito.mock(User.class);

        Mockito.when(userJpaRepository.findByUsername(username)).thenReturn(Optional.of(entity));
        Mockito.when(userEntityMapper.toDomain(entity)).thenReturn(user);

        Optional<User> result = repository.getUserByUsername(username);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());

        Mockito.verify(userJpaRepository).findByUsername(username);
        Mockito.verify(userEntityMapper).toDomain(entity);
        Mockito.verifyNoMoreInteractions(userJpaRepository, userEntityMapper);
    }

    @Test
    void should_return_empty_when_user_not_found_by_username() {
        String username = "user";

        Mockito.when(userJpaRepository.findByUsername(username)).thenReturn(Optional.empty());

        Optional<User> result = repository.getUserByUsername(username);

        assertTrue(result.isEmpty());

        Mockito.verify(userJpaRepository).findByUsername(username);
        Mockito.verifyNoMoreInteractions(userJpaRepository, userEntityMapper);
    }

    @Test
    void should_check_if_email_exists() {
        String email = "test@test.com";

        Mockito.when(userJpaRepository.existsByEmail(email)).thenReturn(true);

        boolean result = repository.existsByEmail(email);

        assertTrue(result);

        Mockito.verify(userJpaRepository).existsByEmail(email);
        Mockito.verifyNoMoreInteractions(userJpaRepository);
    }
}
