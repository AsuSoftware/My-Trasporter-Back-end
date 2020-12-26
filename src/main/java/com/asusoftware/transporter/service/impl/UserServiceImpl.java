package com.asusoftware.transporter.service.impl;

import com.asusoftware.transporter.exception.UserNotFoundException;
import com.asusoftware.transporter.model.User;
import com.asusoftware.transporter.model.dto.AddressDto;
import com.asusoftware.transporter.model.dto.CreateUserDto;
import com.asusoftware.transporter.repository.UserRepository;
import com.asusoftware.transporter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/** transporter Created by Antonio on 12/25/2020 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional
  public User create(CreateUserDto createUserDto) {
    User user = createUser(createUserDto);
    return userRepository.save(user);
  }

  @Override
  public User findById(UUID id) {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  @Override
  public Optional<User> findUserForParcel(CreateUserDto userDto) {
    return userRepository.findByFirstNameAndLastNameAndEmailAndPhone(
        userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPhone());
  }

  @Override
  public void delete(UUID id) {
    userRepository.deleteById(id);
  }

  private User createUser(CreateUserDto createUserDto) {
    User user = new User();
    user.setFirstName(createUserDto.getFirstName());
    user.setLastName(createUserDto.getLastName());
    user.setEmail(createUserDto.getEmail());
    user.setPhone(createUserDto.getPhone());
    user.setAddress(
        Optional.ofNullable(createUserDto.getAddress()).map(AddressDto::toAddress).orElse(null));
    return user;
  }
}
