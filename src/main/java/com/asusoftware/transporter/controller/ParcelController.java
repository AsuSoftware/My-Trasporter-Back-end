package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/parcels")
public class ParcelController {

  private final ParcelService parcelService;
}
