package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;
import com.asusoftware.transporter.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping(path = "/{companyId}")
  public void create(@PathVariable("id")UUID id, @RequestBody CreateEmployeeDto createEmployeeDto) {
    employeeService.create(id, createEmployeeDto);
  }
}
