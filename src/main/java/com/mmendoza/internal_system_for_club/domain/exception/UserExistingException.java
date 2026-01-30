package com.mmendoza.internal_system_for_club.domain.exception;

public class UserExistingException extends RuntimeException {
    public UserExistingException(String message) {
        super(message);
    }
}
