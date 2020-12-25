package com.asusoftware.transporter.service.user.impl;

import com.asusoftware.transporter.model.dto.user.CreateUserDto;
import com.asusoftware.transporter.service.user.UserCreator;
import com.asusoftware.transporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * transporter Created by Antonio on 12/25/2020
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCreator userCreator;

    @Override
    public void create(CreateUserDto createUserDto) {
      userCreator.create(createUserDto);
    }
}
