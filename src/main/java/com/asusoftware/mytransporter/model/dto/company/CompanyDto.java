package com.asusoftware.mytransporter.model.dto.company;

import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class CompanyDto {
    private UUID id;
    private String companyName;
    private String address;
    private List<UserDto> couriers;

    public static CompanyDto mapFromEntity(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setCompanyName(company.getName());
        companyDto.setAddress(company.getAddress());
        companyDto.setCouriers(company.getCouriers().stream().map(UserDto::mapFromEntity).collect(Collectors.toList()));
        return companyDto;
    }
}
