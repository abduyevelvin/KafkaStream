package com.email.kafka.enums;

import lombok.Getter;

@Getter
public enum InvalidEmailEnum {

    INVALID_EMAIL(211, "invalid_email");

    private int code;
    private String message;

    InvalidEmailEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

