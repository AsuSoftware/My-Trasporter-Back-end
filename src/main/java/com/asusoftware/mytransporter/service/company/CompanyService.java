package com.asusoftware.mytransporter.service.company;

import com.asusoftware.mytransporter.model.dto.company.CompanyDto;
import com.asusoftware.mytransporter.model.dto.company.CreateCompanyDto;
import com.asusoftware.mytransporter.model.dto.company.UpdateCompanyDto;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface CompanyService {

    void create(CreateCompanyDto companyDto);
    CompanyDto findById(UUID id);
    List<CompanyDto> findAll();
    List<CompanyDto> findAllById(Iterable<UUID> ids);

    /*
    void update(UUID id, UpdateProductDto product); */

}
