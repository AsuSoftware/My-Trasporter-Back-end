package com.asusoftware.mytransporter.model.dto.company;

import com.asusoftware.mytransporter.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class UpdateCompanyDto {
    @NotBlank private String companyName;
    @Email @NotBlank private String email;
    @NotBlank private String address;
    @NotNull private List<User> users;
}
