package com.asusoftware.transporter.exception;

/** transporter Created by Antonio on 12/25/2020 */
public class UserNotFoundException extends TransporterException {
  public UserNotFoundException() {
    super("User not found!");
  }
}
