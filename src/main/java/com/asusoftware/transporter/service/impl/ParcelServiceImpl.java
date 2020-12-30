package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.ParcelNotFoundException;
import com.asusoftware.transporter.model.*;
import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.model.dto.EmployeeActionDto;
import com.asusoftware.transporter.model.dto.EmployeeDto;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.service.EmployeeOperation;
import com.asusoftware.transporter.service.EmployeeService;
import com.asusoftware.transporter.service.ParcelService;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

  private final ParcelRepository parcelRepository;
  private final UserService userService;
  private final EmployeeService employeeService;

  @Override
  public void create(CreateParcelDto createParcelDto) {
    parcelRepository.save(createParcel(createParcelDto));
  }

  @Override
  public Parcel findById(UUID id) {
    return parcelRepository.findById(id).orElseThrow(ParcelNotFoundException::new);
  }

  @Override
  public void takeOrDeliver(UUID orderId, EmployeeActionDto employeeActionDto) {
    Parcel parcel = parcelRepository.findById(orderId).orElseThrow(ParcelNotFoundException::new);
    Employee employee = employeeService.findById(employeeActionDto.getEmployeeId());
    Map<ParcelEventType, EmployeeOperation> commandMap = new HashMap<>();
    commandMap.put(ParcelEventType.PICK, () -> {
      parcel.setCourier(employee);
      parcel.setTakeoverDate(LocalDateTime.now(ZoneOffset.UTC));
      parcel.setParcelStatus(ParcelStatus.PICKED_UP);
      parcelRepository.save(parcel);
    });

    commandMap.put(ParcelEventType.DELIVER, () -> {
      parcel.setDeliveryDate(LocalDateTime.now(ZoneOffset.UTC));
      parcel.setParcelStatus(ParcelStatus.DELIVERING);
      parcelRepository.save(parcel);
    });
    commandMap.get(employeeActionDto.getEventType()).execute();
  }

  @Override
  public void deliverOrder(UUID orderId) {
    Parcel parcel = parcelRepository.findById(orderId).orElseThrow(ParcelNotFoundException::new);
    parcel.setDeliveryDate(LocalDateTime.now(ZoneOffset.UTC));
    parcelRepository.save(parcel);
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

  //TODO momentan se creaza userul daca nu exista
  // daca exista il folosim pe ala -> atentie ca ignoram adresa care vine pe CreateUserDto
  // poate fi diferita de cea salvata in userul gasit.
  private User findUserOrCreate(CreateUserDto userDto) {
    return userService.findUserForParcel(userDto).orElse(userService.create(userDto));
  }
}
