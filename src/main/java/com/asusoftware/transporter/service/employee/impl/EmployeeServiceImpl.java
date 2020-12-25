package com.asusoftware.transporter.service.employee.impl;

import com.asusoftware.transporter.exception.CompanyNotFoundException;
import com.asusoftware.transporter.model.Address;
import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.address.AddressDto;
import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;
import com.asusoftware.transporter.repository.CompanyRepository;
import com.asusoftware.transporter.repository.EmployeeRepository;
import com.asusoftware.transporter.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void create(CreateEmployeeDto createEmployee) {
        Company company = companyRepository.findById(createEmployee.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        employeeRepository.save(mapEmployeeDtoToEntity(createEmployee, company));
    }

    private Employee mapEmployeeDtoToEntity(CreateEmployeeDto createEmployeeDto, Company company) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeDto.getFirstName());
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setPhone(createEmployeeDto.getPhone());
        employee.setAddress(Optional.ofNullable(createEmployeeDto.getAddress()).map(this::mapAddressDtoToEntity).orElse(null));
        employee.setRole(createEmployeeDto.getEmployeeRole());
        employee.setCompany(company);
        return employee;
    }

    private Address mapAddressDtoToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setStreet(addressDto.getStreet());
        address.setStreetNumber(addressDto.getStreetNumber());
        address.setDetails(addressDto.getDetails());
        address.setZip(addressDto.getZip());
        return address;
    }
}
