package com.asusoftware.mytransporter.controller.payload;

import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class RegisterUserRequest {
    @NotNull
    @Valid
    private CreateUserDto user;
}
