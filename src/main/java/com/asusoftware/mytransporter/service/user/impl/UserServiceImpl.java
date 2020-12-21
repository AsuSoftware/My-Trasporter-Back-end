package com.asusoftware.mytransporter.service.user.impl;

import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import com.asusoftware.mytransporter.service.user.UserCreator;
import com.asusoftware.mytransporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCreator userCreator;

    @Override
    public void register(CreateUserDto user) {
        userCreator.create(user);
    }

    @Override
    public LoggedUserDto login(String username, String password) {
        return LoggedUserDto.builder().id(null).username(null).token(null).build();
    }
}
