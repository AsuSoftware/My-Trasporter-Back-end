package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/** transporter Created by Antonio on 12/25/2020 */
@Getter
@Setter
public class EmployeeDto {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private AddressDto address;
  private CompanyDto company;
  private EmployeeRole role;

  public static EmployeeDto mapFromEntity(Employee employee) {
    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setFirstName(employee.getFirstName());
    employeeDto.setLastName(employee.getLastName());
    employeeDto.setEmail(employee.getEmail());
    employeeDto.setPhone(employee.getPhone());
    employeeDto.setAddress(
        Optional.ofNullable(employee.getAddress()).map(AddressDto::mapFromEntity).orElse(null));
    employeeDto.setCompany(CompanyDto.mapFromEntity(employee.getCompany()));
    employeeDto.setRole(employee.getRole());
    return employeeDto;
  }
}
