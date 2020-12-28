package com.asusoftware.transporter.controller;

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

  @PostMapping(path = "/take/{employeeId}/{id}")
  public void takeOrder(@PathVariable("id") UUID orderId, @PathVariable("employeeId") UUID employeeId) {
    parcelService.takeOrder(orderId, employeeId);
  }

  @PostMapping(path = "/deliver/{id}")
  public void deliverOrder(@PathVariable("id") UUID orderId) {
    parcelService.deliverOrder(orderId);
  }

}
