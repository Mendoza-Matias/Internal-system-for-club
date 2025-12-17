package com.mmendoza.smart_invoice_reminder.controller.advice;

import com.mmendoza.smart_invoice_reminder.domain.dtos.exceptions.ExceptionResponse;
import com.mmendoza.smart_invoice_reminder.exceptions.ResourceNotFoundException;
import com.mmendoza.smart_invoice_reminder.exceptions.ValidationException;
import com.mmendoza.smart_invoice_reminder.mapper.ExceptionMapper;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ControllerHandler {

    private final ExceptionMapper exceptionMapper;

    public ControllerHandler(ExceptionMapper exceptionMapper) {
        this.exceptionMapper = exceptionMapper;
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(ValidationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.ofNullable(exceptionMapper.toExceptionResponse(ex.getMessage(), status.value(), status.getReasonPhrase()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.ofNullable(exceptionMapper.toExceptionResponse(ex.getMessage(), status.value(), status.getReasonPhrase()));
    }
}
