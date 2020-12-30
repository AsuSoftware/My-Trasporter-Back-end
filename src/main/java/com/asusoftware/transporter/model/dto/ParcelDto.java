package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.Parcel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/** transporter Created by Antonio on 12/26/2020 */
@Getter
@Setter
public class ParcelDto {
  private UUID id;
  @NotNull private LocalDateTime registeredDate;
  @Nullable private LocalDateTime takeoverDate;
  @Nullable private LocalDateTime deliveryDate;
  @Nullable private String details;
  @NotNull private UserDto sender;
  @NotNull private UserDto receiver;
  @Nullable private EmployeeDto courier;

  public static ParcelDto mapFromEntity(Parcel parcel) {
    ParcelDto parcelDto = new ParcelDto();
    parcelDto.setId(parcel.getId());
    parcelDto.setRegisteredDate(parcel.getRegisteredDate());
    parcelDto.setTakeoverDate(parcel.getTakeoverDate());
    parcelDto.setDeliveryDate(parcel.getDeliveryDate());
    parcelDto.setDetails(parcel.getDetails());
    parcelDto.setSender(UserDto.mapFromEntity(parcel.getSender()));
    parcelDto.setReceiver(UserDto.mapFromEntity(parcel.getReceiver()));
    parcelDto.setCourier(
        Optional.ofNullable(parcel.getCourier()).map(EmployeeDto::mapFromEntity).orElse(null));
    return parcelDto;
  }
}
