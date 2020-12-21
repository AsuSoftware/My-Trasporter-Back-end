package com.asusoftware.mytransporter.service.user.impl;

import com.asusoftware.mytransporter.model.User;
import com.asusoftware.mytransporter.model.dto.user.CreateUserDto;
import com.asusoftware.mytransporter.repository.UserRepository;
import com.asusoftware.mytransporter.service.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */

@Service
@RequiredArgsConstructor
public class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void create(CreateUserDto user) {
        userRepository.save(createUser(user));
    }

    private User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        user.setAddress(createUserDto.getAddress());
        user.setType(createUserDto.getType());
        return user;
    }
}
