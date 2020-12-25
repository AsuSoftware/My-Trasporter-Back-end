package com.asusoftware.transporter.model.dto.address;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

/** my-transporter Created by Catalin on 12/24/2020 */
@Getter
@Setter
public class AddressDto {
  @Nullable private String city;
  @Nullable private String country;
  @Nullable private String zip;
  @Nullable private String street;
  @Nullable private String streetNumber;
  @Nullable private String details;
}
