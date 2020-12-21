package com.asusoftware.mytransporter.controller;

import com.asusoftware.mytransporter.controller.payload.LoginUserRequest;
import com.asusoftware.mytransporter.controller.payload.LoginUserResponse;
import com.asusoftware.mytransporter.controller.payload.RegisterUserRequest;
import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;
import com.asusoftware.mytransporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void register(@Valid @RequestBody RegisterUserRequest request) {
        userService.register(request.getUser());
    }

    @PostMapping(path = "/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest request) {
        LoggedUserDto user = userService.login(request.getUsername(), request.getPassword());
        return new LoginUserResponse(user);
    }
}
