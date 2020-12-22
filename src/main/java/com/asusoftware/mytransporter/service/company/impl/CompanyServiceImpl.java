package com.asusoftware.mytransporter.service.company.impl;

import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.dto.company.CompanyDto;
import com.asusoftware.mytransporter.model.dto.company.CreateCompanyDto;
import com.asusoftware.mytransporter.service.company.CompanyCreator;
import com.asusoftware.mytransporter.service.company.CompanyFinder;
import com.asusoftware.mytransporter.service.company.CompanyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyCreator companyCreator;
    private final CompanyFinder companyFinder;

    @Override
    public void create(CreateCompanyDto companyDto) {
        companyCreator.create(companyDto);
    }

    @Override
    public CompanyDto findById(UUID id) {
        Company company = companyFinder.findById(id);
        return CompanyDto.mapFromEntity(company);
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyFinder.findAllCompany().stream().map(CompanyDto::mapFromEntity).collect(Collectors.toList());
    }

    @Override
    public List<CompanyDto> findAllById(Iterable<UUID> ids) {
        return companyFinder.findAllById(ids).stream().map(CompanyDto::mapFromEntity).collect(Collectors.toList());
    }
}
