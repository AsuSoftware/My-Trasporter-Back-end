package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.user.CreateUserDto;
import com.asusoftware.transporter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/** my-transporter Created by Catalin on 12/24/2020 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public void createUser(@RequestBody CreateUserDto createUserDto) {
     userService.create(createUserDto);
  }
}
