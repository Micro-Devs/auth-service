package com.microdevs.authservice.exception;

import com.microdevs.baseservice.exception.MicroException;

public class UserSuspendedException extends MicroException {
    public UserSuspendedException(String message, Integer errorCode, String messageDetail) {
        super(message, errorCode, messageDetail);
    }
}
