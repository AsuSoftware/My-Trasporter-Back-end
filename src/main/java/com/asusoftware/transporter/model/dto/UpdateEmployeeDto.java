package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.EmployeeRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * transporter Created by Antonio on 12/30/2020
 */

@Getter
@Setter
public class UpdateEmployeeDto {
   @NotBlank private String firstName;
   @NotBlank private String lastName;
   @NotBlank @Email private String email;
   @NotBlank private String phone;
   @NotNull private AddressDto address;
   @NotNull private UUID companyId;
   @NotNull private EmployeeRole role;
}
