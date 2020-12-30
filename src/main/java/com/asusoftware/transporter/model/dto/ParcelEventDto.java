package com.asusoftware.transporter.model.dto;

import com.asusoftware.transporter.model.ParcelEventType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/** transporter Created by Antonio on 12/29/2020 */
@Getter
@Setter
public class ParcelEventDto {
  private UUID employeeId;
  private ParcelEventType eventType;
}
