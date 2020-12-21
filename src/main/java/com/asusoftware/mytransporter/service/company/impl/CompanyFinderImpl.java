package com.asusoftware.mytransporter.service.company.impl;

import com.asusoftware.mytransporter.exception.company.CompanyNotFoundException;
import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.repository.CompanyRepository;
import com.asusoftware.mytransporter.service.company.CompanyFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class CompanyFinderImpl implements CompanyFinder {

    private final CompanyRepository companyRepository;

    @Override
    public Company findById(UUID id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findAllById(Iterable<UUID> ids) {
        return companyRepository.findAllById(ids);
    }
}
