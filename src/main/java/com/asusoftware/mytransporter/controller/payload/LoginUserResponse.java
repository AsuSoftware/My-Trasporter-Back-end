package com.asusoftware.mytransporter.controller.payload;

import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
@AllArgsConstructor
public class LoginUserResponse {
    private LoggedUserDto user;
}
