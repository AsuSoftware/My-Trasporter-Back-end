package com.asusoftware.transporter.service.employee.impl;

import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;
import com.asusoftware.transporter.service.employee.EmployeeCreator;
import com.asusoftware.transporter.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeCreator employeeCreator;

    @Override
    public void create(UUID id, CreateEmployeeDto createEmployee) {
        employeeCreator.create(id, createEmployee);
    }
}
