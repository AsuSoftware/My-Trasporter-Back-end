package com.asusoftware.mytransporter.controller.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class LoginUserRequest {
    private String username;
    private String password;
}
