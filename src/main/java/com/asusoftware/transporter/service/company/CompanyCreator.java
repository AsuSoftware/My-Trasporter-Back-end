package com.asusoftware.transporter.service.company;

import com.asusoftware.transporter.model.dto.company.CreateCompanyDto;

import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */
public interface CompanyCreator {

    UUID create(CreateCompanyDto createCompanyDto);
}
