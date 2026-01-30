package com.mmendoza.internal_system_for_club.domain.exception.dto;

public record ExceptionDto(int status, String reason, String message) {
    public ExceptionDto(int status, String reason) {
        this(status, reason, null);
    }
}
