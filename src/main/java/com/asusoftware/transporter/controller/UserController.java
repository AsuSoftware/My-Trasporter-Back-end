package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public void create(@Valid @RequestBody CreateUserDto createUserDto) {
    userService.create(createUserDto);
  }

}
