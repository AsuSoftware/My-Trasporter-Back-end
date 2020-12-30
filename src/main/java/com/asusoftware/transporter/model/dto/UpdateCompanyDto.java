package com.asusoftware.transporter.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

/**
 * transporter Created by Antonio on 12/30/2020
 */

@Getter
@Setter
public class UpdateCompanyDto {
    @NotNull
    private String name;
    @NotNull private String description;
    @Nullable
    private String image;
    @Nullable private AddressDto address;
}
