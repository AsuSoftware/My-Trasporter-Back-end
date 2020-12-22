package com.asusoftware.mytransporter.service.user.impl;

import com.asusoftware.mytransporter.exception.user.UserNotFoundException;
import com.asusoftware.mytransporter.model.User;
import com.asusoftware.mytransporter.repository.UserRepository;
import com.asusoftware.mytransporter.service.user.UserFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/22/2020
 */

@Service
@RequiredArgsConstructor
public class UserFinderImpl implements UserFinder {

    private final UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByIds(Iterable<UUID> ids) {
        return userRepository.findAllById(ids);
    }
}
