package com.asusoftware.transporter.service;

import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.CreateUserDto;

import java.util.Optional;
import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
public interface UserService {
  User create(CreateUserDto createUserDto);

  User findById(UUID id);

  Optional<User> findUserForParcel(CreateUserDto createUserDto);

  void delete(UUID id);
}
