package com.asusoftware.mytransporter.exception.company;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public class CompanyException extends RuntimeException {

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyException(Throwable cause) {
        super(cause);
    }

    public CompanyException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
