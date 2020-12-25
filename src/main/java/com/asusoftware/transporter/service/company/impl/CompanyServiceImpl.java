package com.asusoftware.transporter.service.company.impl;

import com.asusoftware.transporter.model.dto.company.CreateCompanyDto;
import com.asusoftware.transporter.service.company.CompanyCreator;
import com.asusoftware.transporter.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyCreator companyCreator;

    @Override
    public UUID create(CreateCompanyDto createCompanyDto) {
        return companyCreator.create(createCompanyDto);
    }
}
