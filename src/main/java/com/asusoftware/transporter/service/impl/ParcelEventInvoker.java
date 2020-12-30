package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.ParcelEventNotSupported;
import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.ParcelEventType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/30/2020 */
@Service
public class ParcelEventInvoker {

  private final Map<ParcelEventType, ParcelEvent> map = new EnumMap<>(ParcelEventType.class);

  public ParcelEventInvoker(
      PickParcelService pickParcelService, DeliverParcelService deliverParcelService) {
    map.put(ParcelEventType.PICK, pickParcelService);
    map.put(ParcelEventType.DELIVER, deliverParcelService);
  }

  public void invoke(ParcelEventType parcelEventType, Parcel parcel, UUID employeeId) {
    ParcelEvent event = get(parcelEventType);
    event.execute(parcel, employeeId);
  }

  private ParcelEvent get(ParcelEventType parcelEventType) {
    return Optional.ofNullable(map.get(parcelEventType)).orElseThrow(ParcelEventNotSupported::new);
  }
}
