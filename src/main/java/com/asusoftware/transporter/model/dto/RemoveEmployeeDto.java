package com.asusoftware.transporter.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * transporter Created by Antonio on 12/30/2020
 */

@Getter
@Setter
public class RemoveEmployeeDto {

    @NotNull private UUID employeeId;
    @NotNull private UUID companyId;
}
