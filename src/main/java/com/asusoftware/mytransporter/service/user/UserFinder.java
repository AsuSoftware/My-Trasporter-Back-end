package com.asusoftware.mytransporter.service.user;

import com.asusoftware.mytransporter.model.User;

import java.util.List;
import java.util.UUID;

/**
 * my-transporter Created by Antonio on 12/22/2020
 */
public interface UserFinder {
    User findById(UUID id);
    List<User> findAll();
    List<User> findAllByIds(Iterable<UUID> ids);
}
