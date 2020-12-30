package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.model.Parcel;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/30/2020 */
public interface ParcelEvent {
  void execute(Parcel parcel, UUID employeeId);
}
