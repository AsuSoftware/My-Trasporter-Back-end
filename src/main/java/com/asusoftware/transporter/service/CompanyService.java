package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.dto.CompanyDto;
import com.asusoftware.transporter.model.dto.CreateCompanyDto;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface CompanyService {

  UUID create(CreateCompanyDto createCompanyDto);

  CompanyDto findById(UUID id);
}
