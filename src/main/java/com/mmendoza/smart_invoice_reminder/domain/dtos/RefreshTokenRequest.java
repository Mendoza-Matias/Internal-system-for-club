package com.mmendoza.smart_invoice_reminder.domain.dtos;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public record RefreshTokenRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
}
