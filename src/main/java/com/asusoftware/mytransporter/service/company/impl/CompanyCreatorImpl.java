package com.asusoftware.mytransporter.service.company.impl;

import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.dto.company.CreateCompanyDto;
import com.asusoftware.mytransporter.repository.CompanyRepository;
import com.asusoftware.mytransporter.service.company.CompanyCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class CompanyCreatorImpl implements CompanyCreator {

    private final CompanyRepository companyRepository;

    @Override
    public void create(CreateCompanyDto companyDto) {
        companyRepository.save(createCompany(companyDto));
    }

    private Company createCompany(CreateCompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        company.setAddress(companyDto.getAddress());
        company.setEmail(companyDto.getEmail());
        return company;
    }
}
