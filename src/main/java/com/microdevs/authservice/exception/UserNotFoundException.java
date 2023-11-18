package com.microdevs.authservice.exception;

import com.microdevs.baseservice.exception.MicroException;

public class UserNotFoundException extends MicroException {
    public UserNotFoundException(String message, Integer errorCode, String messageDetail) {
        super(message, errorCode, messageDetail);
    }
}
