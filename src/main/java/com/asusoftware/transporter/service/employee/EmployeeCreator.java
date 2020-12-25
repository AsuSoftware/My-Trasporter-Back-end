package com.asusoftware.transporter.service.employee;

import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;

import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */
public interface EmployeeCreator {
    void create(UUID id, CreateEmployeeDto createEmployee);
}
