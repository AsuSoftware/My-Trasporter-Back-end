package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.model.dto.UserDto;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface UserService {
  void create(CreateUserDto createUserDto);
  User findById(UUID id);
  void delete(UUID id);
}
