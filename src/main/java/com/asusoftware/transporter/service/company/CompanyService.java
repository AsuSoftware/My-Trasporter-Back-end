package com.asusoftware.transporter.service.company;

import com.asusoftware.transporter.model.dto.company.CreateCompanyDto;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface CompanyService {

  UUID create(CreateCompanyDto createCompanyDto);
}
