package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateEmployeeDto;
import com.asusoftware.transporter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
