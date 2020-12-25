package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.AddressDto;
import com.asusoftware.transporter.model.dto.CreateEmployeeDto;
import com.asusoftware.transporter.repository.EmployeeRepository;
import com.asusoftware.transporter.service.CompanyService;
import com.asusoftware.transporter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final CompanyService companyService;
  private final EmployeeRepository employeeRepository;

  @Override
  @Transactional
  public void create(CreateEmployeeDto createEmployeeDto) {
    Company company = companyService.findById(createEmployeeDto.getCompanyId());
    Employee employee = createEmployee(createEmployeeDto, company);
    employeeRepository.save(employee);
  }

  private Employee createEmployee(CreateEmployeeDto createEmployeeDto, Company company) {
    Employee employee = new Employee();
    employee.setFirstName(createEmployeeDto.getFirstName());
    employee.setLastName(createEmployeeDto.getLastName());
    employee.setEmail(createEmployeeDto.getEmail());
    employee.setPhone(createEmployeeDto.getPhone());
    employee.setAddress(
        Optional.ofNullable(createEmployeeDto.getAddress())
            .map(AddressDto::toAddress)
            .orElse(null));
    employee.setRole(createEmployeeDto.getEmployeeRole());
    employee.setCompany(company);
    return employee;
  }
}
