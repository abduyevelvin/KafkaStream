package com.email.kafka.enums;

import lombok.Getter;

@Getter
public enum NotFoundErrorEnum {

    EMAILS_NOT_FOUND(111, "emails_not_found");

    private int code;
    private String message;

    NotFoundErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}