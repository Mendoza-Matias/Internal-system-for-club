package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.http.advice;

import com.mmendoza.internal_system_for_club.domain.exception.RoleNotConfiguredException;
import com.mmendoza.internal_system_for_club.domain.exception.UserExistingException;
import com.mmendoza.internal_system_for_club.domain.exception.UserNotFoundException;
import com.mmendoza.internal_system_for_club.domain.exception.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RoleNotConfiguredException.class})
    @ResponseBody
    public ResponseEntity<ExceptionDto> handleRoleNotConfiguredException(RoleNotConfiguredException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(HttpStatus.NOT_FOUND.value(), "NOT FOUND", exception.getMessage()));
    }

    @ExceptionHandler(value = {UserExistingException.class})
    @ResponseBody
    public ResponseEntity<ExceptionDto> handleUserExistingException(UserExistingException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(HttpStatus.NOT_FOUND.value(), "NOT FOUND", exception.getMessage()));
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ExceptionDto> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(HttpStatus.NOT_FOUND.value(), "NOT FOUND", exception.getMessage()));
    }
}
