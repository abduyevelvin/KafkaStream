package com.email.kafka.exception;

import lombok.Data;

@Data
public class EmailsAbstractException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected final Integer errorCode;
    protected final String message;

    public EmailsAbstractException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
