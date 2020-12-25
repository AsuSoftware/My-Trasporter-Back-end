package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/** transporter Created by Antonio on 12/25/2020 */
@Getter
@Setter
public class CreateUserDto {
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @Email @Nullable private String email;
  @Nullable private String phone;
  @Nullable private AddressDto address;
}
