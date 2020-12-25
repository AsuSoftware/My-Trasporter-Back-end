package com.asusoftware.transporter.exception;

/**
 * transporter Created by Antonio on 12/25/2020
 */
public class ParcelNotFoundException extends TransporterException{
    public ParcelNotFoundException() {
        super("Parcel not found!");
    }
}
