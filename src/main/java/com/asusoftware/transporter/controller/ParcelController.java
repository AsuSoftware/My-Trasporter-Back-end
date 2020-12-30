package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.ParcelEventDto;
import com.asusoftware.transporter.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcels")
public class ParcelController {

  private final ParcelService parcelService;

  @PostMapping(path = "/{id}/event")
  public void execute(
      @PathVariable("id") UUID orderId, @RequestBody ParcelEventDto parcelEventDto) {
    parcelService.executeEvent(orderId, parcelEventDto);
  }
}
