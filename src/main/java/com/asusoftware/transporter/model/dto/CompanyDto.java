package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.Company;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Setter
@Getter
public class CompanyDto {
    private UUID id;
    @NotNull private String name;
    @NotNull private String description;
    @Nullable private String image;
    @Nullable private AddressDto address;

    public Company toCompany() {
        Company company = new Company();
        company.setName(name);
        company.setDescription(description);
        company.setImage(image);
        company.setAddress(Optional.ofNullable(address).map(AddressDto::toAddress).orElse(null));
        return company;
    }

    public static CompanyDto mapFromEntity(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setDescription(company.getDescription());
        companyDto.setImage(company.getImage());
        companyDto.setAddress(Optional.ofNullable(company.getAddress()).map(AddressDto::mapFromEntity).orElse(null));
        return companyDto;
    }
}
