package com.asusoftware.mytransporter.model.dto.company;

import com.asusoftware.mytransporter.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class CreateCompanyDto {
    @NotBlank private String name;
    @NotBlank private String address;
    private List<User> couriers;
}
