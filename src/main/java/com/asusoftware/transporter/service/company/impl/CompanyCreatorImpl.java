package com.asusoftware.transporter.service.company.impl;

import com.asusoftware.transporter.model.Address;
import com.asusoftware.transporter.model.Company;
import com.asusoftware.transporter.model.dto.address.AddressDto;
import com.asusoftware.transporter.model.dto.company.CreateCompanyDto;
import com.asusoftware.transporter.repository.CompanyRepository;
import com.asusoftware.transporter.service.company.CompanyCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class CompanyCreatorImpl implements CompanyCreator {

    private final CompanyRepository companyRepository;

    @Override
    public UUID create(CreateCompanyDto createCompanyDto) {
        Company company = companyRepository.save(mapCompanyDtoToEntity(createCompanyDto));
        return company.getId();
    }

    private Company mapCompanyDtoToEntity(CreateCompanyDto createCompanyDto) {
        Company company = new Company();
        company.setName(createCompanyDto.getName());
        company.setAddress(Optional.ofNullable(createCompanyDto.getAddress()).map(this::mapAddressDtoToEntity).orElse(null));
        company.setDescription(createCompanyDto.getDescription());
        company.setImage(createCompanyDto.getImage());
        return company;
    }

    private Address mapAddressDtoToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setStreet(addressDto.getStreet());
        address.setStreetNumber(addressDto.getStreetNumber());
        address.setDetails(addressDto.getDetails());
        address.setZip(addressDto.getZip());
        return address;
    }
}
