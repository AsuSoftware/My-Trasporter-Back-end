package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.dto.CreateCompanyDto;
import com.asusoftware.transporter.model.dto.RemoveEmployeeDto;
import com.asusoftware.transporter.model.dto.UpdateCompanyDto;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface CompanyService {

  UUID create(CreateCompanyDto createCompanyDto);
  Company findById(UUID id);
  void update(UUID companyId, UpdateCompanyDto updateCompanyDto);
}
