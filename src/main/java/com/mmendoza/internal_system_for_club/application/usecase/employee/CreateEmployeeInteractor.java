package com.mmendoza.internal_system_for_club.application.usecase.employee;

import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.domain.model.User;
import com.mmendoza.internal_system_for_club.domain.ports.in.AddRoleToUserUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.in.CreateEmployeeUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.in.GetUserByIdUseCase;
import com.mmendoza.internal_system_for_club.domain.ports.out.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateEmployeeInteractor implements CreateEmployeeUseCase {

    private final GetUserByIdUseCase getUserById;
    private final AddRoleToUserUseCase addRole;
    private final EmployeeRepository employeeRepository;

    public CreateEmployeeInteractor(GetUserByIdUseCase getUserById, AddRoleToUserUseCase addRole, EmployeeRepository employeeRepository) {
        this.getUserById = getUserById;
        this.addRole = addRole;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {

        User user = getUserById.findById(employee.getUserId());

        employeeRepository.save(employee, user);

        addRole.addRole(user, "EMPLOYEE");
    }
}

