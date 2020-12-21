package com.asusoftware.mytransporter.model.dto.company;

import com.asusoftware.mytransporter.model.Company;
import com.asusoftware.mytransporter.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class CompanyDto {
    private UUID id;
    private String companyName;
    private String email;
    private String address;
    private List<User> userList;

    public static CompanyDto mapFromEntity(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setEmail(company.getEmail());
        companyDto.setAddress(company.getAddress());
        companyDto.setUserList(company.getUserList());
        return companyDto;
    }
}
