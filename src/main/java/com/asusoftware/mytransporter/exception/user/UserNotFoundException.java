package com.asusoftware.mytransporter.exception.user;

/**
 * my-transporter Created by Antonio on 12/22/2020
 */
public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super("User not found");
    }
}
