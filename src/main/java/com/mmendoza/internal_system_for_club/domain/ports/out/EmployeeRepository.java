package com.mmendoza.internal_system_for_club.domain.ports.out;

import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.domain.model.User;

public interface EmployeeRepository {
    void save(Employee employee);
}
