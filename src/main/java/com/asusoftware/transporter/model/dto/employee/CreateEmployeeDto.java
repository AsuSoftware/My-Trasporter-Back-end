package com.asusoftware.transporter.model.dto.employee;

import com.asusoftware.transporter.model.EmployeeRole;
import com.asusoftware.transporter.model.dto.address.AddressDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * transporter Created by Antonio on 12/25/2020
 */

@Getter
@Setter
public class CreateEmployeeDto {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    @Email @Nullable private String email;
    @Nullable private String phone;
    @Nullable private AddressDto address;
    @NotNull private EmployeeRole employeeRole;
}
