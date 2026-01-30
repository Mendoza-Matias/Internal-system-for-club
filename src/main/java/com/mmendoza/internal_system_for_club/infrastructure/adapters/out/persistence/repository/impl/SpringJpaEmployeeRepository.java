package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.impl;

import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.out.EmployeeRepository;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.mapper.EmployeeEntityMapper;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository.EmployeeJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class SpringJpaEmployeeRepository implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;

    private final EmployeeEntityMapper employeeEntityMapper;

    public SpringJpaEmployeeRepository(EmployeeJpaRepository employeeJpaRepository, EmployeeEntityMapper employeeEntityMapper) {
        this.employeeJpaRepository = employeeJpaRepository;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    @Override
    public void save(Employee employee) {
        employeeJpaRepository.save(employeeEntityMapper.toEntity(employee));
    }
}
