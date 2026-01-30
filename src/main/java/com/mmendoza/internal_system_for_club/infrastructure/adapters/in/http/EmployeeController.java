package com.mmendoza.internal_system_for_club.infrastructure.adapters.in.http;

import com.mmendoza.internal_system_for_club.application.usecase.employee.CreateEmployeeInteractor;
import com.mmendoza.internal_system_for_club.domain.model.Employee;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.dto.request.CreateEmployeeRequest;
import com.mmendoza.internal_system_for_club.infrastructure.adapters.in.mapper.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CreateEmployeeInteractor createEmployeeInteractor;

    private final EmployeeMapper employeeMapper;

    public EmployeeController(CreateEmployeeInteractor createEmployeeInteractor, EmployeeMapper employeeMapper) {
        this.createEmployeeInteractor = createEmployeeInteractor;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request) {

        Employee employee = employeeMapper.toDomain(request);

        createEmployeeInteractor.save(employee);

        return ResponseEntity.created(URI.create("/employees")).build();
    }
}
