package com.microdevs.authservice.constant;

public class UserConstant {
    //    Error Codes
    public static final int ERROR_CODE_USER_NOT_FOUND = 600;
    public static final int ERROR_CODE_USER_STATUS_TERMINATED = 601;
    public static final int ERROR_CODE_USER_STATUS_SUSPENDED = 602;
    //    Error Messages
    public static final String ERROR_MESSAGE_USER_NOT_FOUND = "User Not Found";
    public static final String ERROR_MESSAGE_USER_STATUS_TERMINATED = "User status Terminated";
    public static final String ERROR_MESSAGE_USER_STATUS_SUSPENDED = "User status Suspended";
    // Error Messages
    public static final String ERROR_DETAILED_MESSAGE_USER_NOT_FOUND_WITH_PHONE = "User does not exist with the given phone number";
    public static final String ERROR_DETAILED_MESSAGE_USER_STATUS_TERMINATED = "User was already terminated";
    public static final String ERROR_DETAILED_MESSAGE_USER_STATUS_SUSPENDED = "User was already suspended";
}
