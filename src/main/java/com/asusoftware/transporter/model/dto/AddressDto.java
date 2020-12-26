package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.Address;
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

  public Address toAddress() {
    Address address = new Address();
    address.setCity(city);
    address.setCountry(country);
    address.setStreet(street);
    address.setStreetNumber(streetNumber);
    address.setDetails(details);
    address.setZip(zip);
    return address;
  }

  public static AddressDto mapFromEntity(Address address) {
    AddressDto addressDto = new AddressDto();
    addressDto.setCity(address.getCity());
    addressDto.setCountry(address.getCountry());
    addressDto.setZip(address.getZip());
    addressDto.setStreet(address.getStreet());
    addressDto.setStreetNumber(address.getStreetNumber());
    addressDto.setDetails(address.getDetails());
    return addressDto;
  }
}
