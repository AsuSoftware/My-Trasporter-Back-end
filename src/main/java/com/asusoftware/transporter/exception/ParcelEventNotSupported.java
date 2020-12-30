package com.asusoftware.transporter.exception;

/** my-transporter Created by Catalin on 12/30/2020 */
public class ParcelEventNotSupported extends TransporterException {
  public ParcelEventNotSupported() {
    super("This parcel event is not supported");
  }
}
