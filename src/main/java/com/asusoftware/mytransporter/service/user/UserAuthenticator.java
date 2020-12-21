package com.asusoftware.mytransporter.service.user;

import com.asusoftware.mytransporter.model.dto.user.LoggedUserDto;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public interface UserAuthenticator {
    LoggedUserDto login(String username, String password);
}
