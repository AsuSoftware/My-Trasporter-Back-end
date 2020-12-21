package com.asusoftware.mytransporter.model.dto.user;

import com.asusoftware.mytransporter.model.UserType;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Getter
@Setter
public class CreateUserDto {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    @Email @NotBlank private String email;
    @NotBlank private String password;
    @Nullable private String phone;
    @Nullable private String address;
    @NotNull private UserType type;
}
