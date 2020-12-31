package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.CreateEmployeeDto;
import com.asusoftware.transporter.model.dto.RemoveEmployeeDto;
import com.asusoftware.transporter.model.dto.UpdateEmployeeDto;

import java.util.List;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface EmployeeService {

  void create(CreateEmployeeDto createEmployeeDto);
  Employee findById(UUID id);
  void update(UUID employeeId, UpdateEmployeeDto updateEmployeeDto);
  void delete(UUID id);
  void removeEmployee(RemoveEmployeeDto removeEmployeeDto);
  List<Employee> findFreeEmployees();
}
