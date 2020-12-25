package com.asusoftware.transporter.service.user;

import com.asusoftware.transporter.model.dto.user.CreateUserDto;


/**
 * my-transporter
 * Created by Catalin on 12/24/2020
 **/
public interface UserService {
    void create(CreateUserDto createUserDto);
}
