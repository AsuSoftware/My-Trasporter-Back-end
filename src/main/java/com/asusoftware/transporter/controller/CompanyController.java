package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateCompanyDto;
import com.asusoftware.transporter.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {
  private final CompanyService companyService;

  @PostMapping
  public UUID createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
    return companyService.create(createCompanyDto);
  }
}
