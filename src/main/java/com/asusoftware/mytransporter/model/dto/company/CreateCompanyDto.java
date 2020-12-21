package com.asusoftware.mytransporter.model.dto.company;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class CreateCompanyDto {
    @NotBlank private String companyName;
    @Email @NotBlank private String email;
    @NotBlank private String address;
}
