package com.asusoftware.transporter.service.employee;

import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;

import java.util.UUID;

/**
 * my-transporter
 * Created by Catalin on 12/24/2020
 **/
public interface EmployeeService {
    void create(CreateEmployeeDto createEmployee);
}
