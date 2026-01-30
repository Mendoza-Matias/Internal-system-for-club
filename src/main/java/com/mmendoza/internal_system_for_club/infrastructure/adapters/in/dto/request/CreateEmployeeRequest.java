package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request;

import java.time.LocalDate;

public record CreateEmployeeRequest(String name, String lastName, LocalDate birtDate, String cellphone, Long userId) {
}
