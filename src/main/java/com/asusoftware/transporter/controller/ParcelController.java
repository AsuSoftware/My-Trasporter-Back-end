package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.ParcelEventDto;
import com.asusoftware.transporter.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcels")
public class ParcelController {

  private final ParcelService parcelService;

  @PostMapping
  public void create(@RequestBody CreateParcelDto createParcelDto) {
    parcelService.create(createParcelDto);
  }

  @PostMapping(path = "/{id}/event")
  public void execute(
      @PathVariable("id") UUID id, @RequestBody ParcelEventDto parcelEventDto) {
    parcelService.executeEvent(id, parcelEventDto);
  }
}
