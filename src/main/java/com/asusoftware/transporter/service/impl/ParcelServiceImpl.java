package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.ParcelNotFoundException;
import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.ParcelStatus;
import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.model.dto.ParcelEventDto;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.service.ParcelService;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

  private final ParcelRepository parcelRepository;
  private final UserService userService;
  private final ParcelEventInvoker parcelEventInvoker;

  @Override
  public void create(CreateParcelDto createParcelDto) {
    parcelRepository.save(createParcel(createParcelDto));
  }

  @Override
  public Parcel findById(UUID id) {
    return parcelRepository.findById(id).orElseThrow(ParcelNotFoundException::new);
  }

  @Override
  public void executeEvent(UUID parcelId, ParcelEventDto parcelEventDto) {
    Parcel parcel = parcelRepository.findById(parcelId).orElseThrow(ParcelNotFoundException::new);
    parcelEventInvoker.invoke(
        parcelEventDto.getEventType(), parcel, parcelEventDto.getEmployeeId());
  }

  private Parcel createParcel(CreateParcelDto createParcelDto) {
    Parcel parcel = new Parcel();
    parcel.setRegisteredDate(LocalDateTime.now(ZoneOffset.UTC));
    parcel.setSender(findUserOrCreate(createParcelDto.getSender()));
    parcel.setReceiver(findUserOrCreate(createParcelDto.getReceiver()));
    parcel.setDetails(createParcelDto.getDetails());
    parcel.setParcelStatus(ParcelStatus.NEW);
    return parcel;
  }

  // TODO momentan se creaza userul daca nu exista
  // daca exista il folosim pe ala -> atentie ca ignoram adresa care vine pe CreateUserDto
  // poate fi diferita de cea salvata in userul gasit.
  private User findUserOrCreate(CreateUserDto userDto) {
    return userService.findUserForParcel(userDto).orElse(userService.create(userDto));
  }
}
