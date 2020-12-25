package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

/** my-transporter Created by Catalin on 12/24/2020 */
@Getter
@Setter
public class CreateCompanyDto {
  @NotBlank private String name;
  @Nullable private String description;
  @Nullable private String image;
  @Nullable private AddressDto address;
}
