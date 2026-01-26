package com.mmendoza.internal.domain.ports.in;

import com.mmendoza.internal.domain.model.User;

public interface RegisterUserUseCase {
    void register(User user);
}
