package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateEmployeeDto;
import com.asusoftware.transporter.model.dto.RemoveEmployeeDto;
import com.asusoftware.transporter.model.dto.UpdateEmployeeDto;
import com.asusoftware.transporter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

  @PutMapping(path = "/id")
  public void update(@PathVariable("id") UUID employeeId, @Valid @RequestBody UpdateEmployeeDto updateEmployeeDto) {
    employeeService.update(employeeId, updateEmployeeDto);
  }

  @DeleteMapping(path = "/{id}")
  public void removeEmployee(@Valid @RequestBody RemoveEmployeeDto removeEmployeeDto) {
    employeeService.removeEmployee(removeEmployeeDto);
  }
}
