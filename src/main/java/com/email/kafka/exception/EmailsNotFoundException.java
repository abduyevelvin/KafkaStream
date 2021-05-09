package com.email.kafka.exception;
import com.email.kafka.enums.NotFoundErrorEnum;
import lombok.Data;

@Data
public class EmailsNotFoundException extends EmailsAbstractException {
    private static final long serialVersionUID = 1L;

    public EmailsNotFoundException(NotFoundErrorEnum notFoundErrorEnum) {
        super(notFoundErrorEnum.getCode(), notFoundErrorEnum.getMessage().toLowerCase());
    }
}
