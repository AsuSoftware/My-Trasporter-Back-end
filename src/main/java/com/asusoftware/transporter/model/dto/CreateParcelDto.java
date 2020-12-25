package com.asusoftware.transporter.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/** transporter Created by Catalin on 12/25/2020 */
@Getter
@Setter
public class CreateParcelDto {
  @Nullable private String details;
  @Valid @NotNull private CreateUserDto sender;
  @Valid @NotNull private CreateUserDto receiver;
  @NotNull private UUID companyId;
}
