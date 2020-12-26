package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.Parcel;
import com.asusoftware.transporter.model.dto.CreateParcelDto;
import com.asusoftware.transporter.model.dto.ParcelDto;
import com.asusoftware.transporter.repository.ParcelRepository;
import com.asusoftware.transporter.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcels")
public class ParcelController {

  private final ParcelService parcelService;
  private final ParcelRepository parcelRepository;

  @PostMapping
  public void create(@RequestBody CreateParcelDto createParcelDto) {
    parcelService.create(createParcelDto);
  }

  @GetMapping(path = "/{id}")
  public ParcelDto findById(@PathVariable("id") UUID id) {
    return parcelService.findById(id);
  }

  @GetMapping
  public List<ParcelDto> findAll() {
    return parcelRepository.findAll().stream().map(ParcelDto::mapFromEntity).collect(Collectors.toList());
  }
}
