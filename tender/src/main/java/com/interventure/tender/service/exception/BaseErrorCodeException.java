package com.interventure.tender.service.exception;

public class BaseErrorCodeException extends BusinessException {
    private String errorCode;
    private String description;

    public BaseErrorCodeException(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
