package com.asusoftware.mytransporter.service.user;

import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface UserCreator {
    void create(CreateUserDto user);
}
