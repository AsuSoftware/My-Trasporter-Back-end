package com.asusoftware.mytransporter.service.company;

import com.asusoftware.mytransporter.model.Company;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface CompanyFinder {
    Company findById(UUID id);
    List<Company> findAllCompany();
    List<Company> findAllById(Iterable<UUID> ids);
}
