package com.asusoftware.transporter.exception;

/**
 * transporter Created by Antonio on 12/25/2020
 */
public class CompanyNotFoundException extends TransporterException{
    public CompanyNotFoundException() {
        super("Company not found!");
    }
}
