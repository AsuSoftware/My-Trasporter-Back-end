package com.asusoftware.mytransporter.service.user;

import com.asusoftware.mytransporter.model.User;
import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import com.asusoftware.mytransporter.model.dto.user.UserDto;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface UserService {

    void register(CreateUserDto user);
    UserDto findById(UUID id);
    List<UserDto> findAll();
    List<UserDto> findAllByIds(Iterable<UUID> ids);
    LoggedUserDto login(String username, String password);
}
