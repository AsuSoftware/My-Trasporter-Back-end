package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.EmployeeActionDto;
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

  @PostMapping(path = "/{id}/event")
  public void takeOrDeliver(@PathVariable("id") UUID orderId, @RequestBody EmployeeActionDto employeeActionDto) {
    parcelService.takeOrDeliver(orderId, employeeActionDto);
  }
}
