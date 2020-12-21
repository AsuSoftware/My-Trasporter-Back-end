package com.asusoftware.mytransporter.service.company.impl;

import com.asusoftware.mytransporter.exception.company.CompanyNotFoundException;
import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.dto.company.UpdateCompanyDto;
import com.asusoftware.mytransporter.repository.CompanyRepository;
import com.asusoftware.mytransporter.service.company.CompanyUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

// @TODO make userList convert to User, so the input will be UserDto and the convert type will be User

@Service
@RequiredArgsConstructor
public class CompanyUpdaterImpl implements CompanyUpdater {

    private final CompanyRepository companyRepository;

    @Override
    public void update(UUID id, UpdateCompanyDto updateCompanyDto) {
        Company company = companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        companyRepository.save(updateCompany(company, updateCompanyDto));
    }

    private Company updateCompany(Company company, UpdateCompanyDto updateCompanyDto) {
        company.setCompanyName(updateCompanyDto.getCompanyName());
        company.setEmail(updateCompanyDto.getEmail());
        company.setAddress(updateCompanyDto.getAddress());
        company.setUserList(updateCompanyDto.getUsers());
        return company;
    }
}
