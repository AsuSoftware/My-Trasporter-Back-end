package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.model.Employee;
import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.ParcelStatus;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/30/2020 */
@Service
@RequiredArgsConstructor
public class PickParcelService implements ParcelEvent {

  private final EmployeeService employeeService;
  private final ParcelRepository parcelRepository;

  @Override
  @Transactional
  public void execute(Parcel parcel, UUID employeeId) {
    Employee employee = employeeService.findById(employeeId);
    parcel.setCourier(employee);
    parcel.setTakeoverDate(LocalDateTime.now(ZoneOffset.UTC));
    parcel.setParcelStatus(ParcelStatus.PICKED_UP);
    parcelRepository.save(parcel);
  }
}
