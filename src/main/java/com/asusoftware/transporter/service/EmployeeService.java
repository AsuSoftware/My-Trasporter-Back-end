package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.CreateEmployeeDto;

import java.util.List;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface EmployeeService {
  void create(CreateEmployeeDto createEmployeeDto);

  Employee findById(UUID id);

  void delete(UUID id);

  List<Employee> findFreeEmployees();
}