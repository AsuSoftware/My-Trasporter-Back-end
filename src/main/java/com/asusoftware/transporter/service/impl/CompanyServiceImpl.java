package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.CompanyNotFoundException;
import com.asusoftware.transporter.exception.EmployeeNotFoundException;
import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.dto.AddressDto;
import com.asusoftware.transporter.model.dto.CreateCompanyDto;
import com.asusoftware.transporter.model.dto.RemoveEmployeeDto;
import com.asusoftware.transporter.model.dto.UpdateCompanyDto;
import com.asusoftware.transporter.repository.CompanyRepository;
import com.asusoftware.transporter.repository.EmployeeRepository;
import com.asusoftware.transporter.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;
  private final EmployeeRepository employeeRepository;

  @Override
  @Transactional
  public UUID create(CreateCompanyDto createCompanyDto) {
    Company company = createCompany(createCompanyDto);
    companyRepository.save(company);
    return company.getId();
  }

  @Override
  public Company findById(UUID id) {
    return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
  }

  @Override
  public void update(UUID companyId, UpdateCompanyDto updateCompanyDto) {
    Company company = findById(companyId);
    company.setName(updateCompanyDto.getName());
    company.setImage(updateCompanyDto.getImage());
    company.setDescription(company.getDescription());
    company.setAddress(Optional.ofNullable(updateCompanyDto.getAddress()).map(AddressDto::toAddress).orElse(company.getAddress()));
    companyRepository.save(company);
  }


  private Company createCompany(CreateCompanyDto createCompanyDto) {
    Company company = new Company();
    company.setName(createCompanyDto.getName());
    company.setAddress(
        Optional.ofNullable(createCompanyDto.getAddress()).map(AddressDto::toAddress).orElse(null));
    company.setDescription(createCompanyDto.getDescription());
    company.setImage(createCompanyDto.getImage());
    return company;
  }
}
