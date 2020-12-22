package com.asusoftware.mytransporter.controller;

import com.asusoftware.mytransporter.model.dto.company.CompanyDto;
import com.asusoftware.mytransporter.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * my-transporter Created by Antonio on 12/22/2020
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<CompanyDto> findAll() {
       return companyService.findAll();
    }
}
