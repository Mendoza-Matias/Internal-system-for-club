package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper;

import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.EmployeeEntity;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper {

    private final UserEntityMapper userEntityMapper;

    public EmployeeEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public EmployeeEntity toEntity(Employee employee) {
        return new EmployeeEntity(
                employee.getId(),
                employee.getName(),
                employee.getLastName(),
                employee.getBirthDate(),
                employee.getCellPhone(),
                null
        );
    }
}
