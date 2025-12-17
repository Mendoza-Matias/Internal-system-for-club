package com.mmendoza.smart_invoice_reminder.mapper;

import com.mmendoza.smart_invoice_reminder.domain.dtos.exceptions.ExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMapper {
    public ExceptionResponse toExceptionResponse(String message, int code, String reason) {
        return new ExceptionResponse(message, code, reason);
    }
}
