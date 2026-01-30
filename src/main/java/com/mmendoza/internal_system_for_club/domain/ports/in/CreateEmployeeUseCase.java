package com.mmendoza.internal_system_for_club.domain.ports.in;

import com.mmendoza.internal_system_for_club.domain.model.Employee;

public interface CreateEmployeeUseCase {
    void create(Employee employee);
}
