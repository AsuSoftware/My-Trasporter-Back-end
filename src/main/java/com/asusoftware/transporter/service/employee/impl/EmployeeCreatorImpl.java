package com.asusoftware.transporter.service.employee.impl;

import com.asusoftware.transporter.exception.CompanyNotFoundException;
import com.asusoftware.transporter.model.Address;
import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.address.AddressDto;
import com.asusoftware.transporter.model.dto.employee.CreateEmployeeDto;
import com.asusoftware.transporter.repository.CompanyRepository;
import com.asusoftware.transporter.repository.EmployeeRepository;
import com.asusoftware.transporter.service.employee.EmployeeCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class EmployeeCreatorImpl implements EmployeeCreator {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void create(UUID id, CreateEmployeeDto createEmployee) {
        Company company = companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        Employee employee = mapEmployeeDtoToEntity(createEmployee);
        employee.setCompany(company);
        employeeRepository.save(employee);
    }

    private Employee mapEmployeeDtoToEntity(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeDto.getFirstName());
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setPhone(createEmployeeDto.getPhone());
        if (createEmployeeDto.getAddress() != null) {
            employee.setAddress(mapAddressDtoToEntity(createEmployeeDto.getAddress()));
        }
        employee.setRole(createEmployeeDto.getEmployeeRole());
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
