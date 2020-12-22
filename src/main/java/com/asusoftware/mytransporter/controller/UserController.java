package com.asusoftware.mytransporter.controller;

import com.asusoftware.mytransporter.controller.payload.LoginUserRequest;
import com.asusoftware.mytransporter.controller.payload.LoginUserResponse;
import com.asusoftware.mytransporter.model.UserType;
import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import com.asusoftware.mytransporter.model.dto.user.UserDto;
import com.asusoftware.mytransporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody CreateUserDto request) {
        userService.register(request);
    }

    @PostMapping(path = "/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest request) {
        LoggedUserDto user = userService.login(request.getUsername(), request.getPassword());
        return new LoginUserResponse(user);
    }

    @GetMapping(path = "/userTypes")
    @ResponseStatus(HttpStatus.FOUND)
    public List<UserType> getUserTypes() {
        return Arrays.asList(UserType.values());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<UserDto> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UserDto findById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }
}
