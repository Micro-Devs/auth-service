package com.microdevs.authservice.exception;

import com.microdevs.baseservice.exception.MicroException;

public class UserTerminatedException extends MicroException {
    public UserTerminatedException(String message, Integer errorCode, String messageDetail) {
        super(message, errorCode, messageDetail);
    }
}
