package com.asusoftware.transporter.service.user;

import com.asusoftware.transporter.model.dto.user.CreateUserDto;


/**
 * transporter Created by Antonio on 12/25/2020
 */
public interface UserCreator {
    void create(CreateUserDto createUserDto);
}
