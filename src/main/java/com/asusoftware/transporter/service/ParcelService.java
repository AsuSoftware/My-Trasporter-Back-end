package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.ParcelDto;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface ParcelService {
  void create(CreateParcelDto createParcelDto);
  Parcel findById(UUID id);
}
