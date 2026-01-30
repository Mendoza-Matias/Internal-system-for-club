package com.mmendoza.internal_system_for_club.domain.ports.in;

public interface AuthenticateUserUseCase {
    String login(String username, String password);
}
