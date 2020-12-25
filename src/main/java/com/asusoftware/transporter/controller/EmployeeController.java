package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.CreateEmployeeDto;
import com.asusoftware.transporter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  public void create(@Valid @RequestBody CreateEmployeeDto createEmployeeDto) {
    employeeService.create(createEmployeeDto);
  }

  @GetMapping(path = "/{id}")
  public Employee findById(@PathVariable("id") UUID id) {
    return employeeService.findById(id);
  }

  @GetMapping
  public List<Employee> findAll() {
    return employeeService.findFreeEmployees();
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") UUID id) {
    employeeService.delete(id);
  }
}
