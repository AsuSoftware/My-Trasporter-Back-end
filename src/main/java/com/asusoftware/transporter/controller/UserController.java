package com.asusoftware.transporter.controller;

import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.model.dto.UserDto;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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

  @GetMapping(path = "/{id}")
  public UserDto findById(@PathVariable("id") UUID id) {
    return userService.findById(id);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") UUID id) {
    userService.delete(id);
  }

}
