package com.asusoftware.mytransporter.service.company;

import com.asusoftware.mytransporter.model.dto.company.UpdateCompanyDto;

import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface CompanyUpdater {
    void update(UUID id, UpdateCompanyDto updateCompanyDto);
}
