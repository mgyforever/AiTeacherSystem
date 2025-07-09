package com.ccut.teachingaisystem.exception;

public class SystemException extends RuntimeException {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SystemException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public SystemException(String message, String code) {
        super(message);
        this.code = code;
    }
}
