package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.mapper;

import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.CreateEmployeeRequest;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toDomain(CreateEmployeeRequest request) {
        return new Employee(
                request.name(),
                request.lastName(),
                request.birtDate(),
                request.cellphone(),
                request.userId()
        );
    }

}
