package com.email.kafka.exception;

import com.email.kafka.enums.InvalidEmailEnum;
import lombok.Data;

@Data
public class InvalidEmailException extends EmailsAbstractException {

    private static final long serialVersionUID = 1L;

    public InvalidEmailException(InvalidEmailEnum invalidEmailEnum) {
        super(invalidEmailEnum.getCode(), invalidEmailEnum.getMessage().toLowerCase());
    }
}
