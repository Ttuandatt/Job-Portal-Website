package com.daniel.jobportal.exception;

public enum ErrorCode {
    EMAIL_EXISTED(1001, "Email already in use!");


    private int code;
    private String message;

    ErrorCode() {}

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
