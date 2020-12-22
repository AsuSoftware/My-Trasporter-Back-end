package com.asusoftware.mytransporter.service.user.impl;

import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import com.asusoftware.mytransporter.model.dto.user.UserDto;
import com.asusoftware.mytransporter.service.user.UserCreator;
import com.asusoftware.mytransporter.service.user.UserFinder;
import com.asusoftware.mytransporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCreator userCreator;
    private final UserFinder userFinder;

    @Override
    public void register(CreateUserDto user) {
        userCreator.create(user);
    }

    @Override
    public UserDto findById(UUID id) {
        return UserDto.mapFromEntity(userFinder.findById(id));
    }

    @Override
    public List<UserDto> findAll() {
        return userFinder.findAll().stream().map(UserDto::mapFromEntity).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByIds(Iterable<UUID> ids) {
        return userFinder.findAllByIds(ids).stream().map(UserDto::mapFromEntity).collect(Collectors.toList());
    }

    @Override
    public LoggedUserDto login(String username, String password) {
        return LoggedUserDto.builder().id(null).username(null).token(null).build();
    }
}
