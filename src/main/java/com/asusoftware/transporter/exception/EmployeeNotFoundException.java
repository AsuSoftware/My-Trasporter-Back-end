package com.asusoftware.transporter.exception;

/** transporter Created by Antonio on 12/25/2020 */
public class EmployeeNotFoundException extends TransporterException {
  public EmployeeNotFoundException() {
    super("Employee not found!");
  }
}
