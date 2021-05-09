package com.email.kafka.controller;

import com.email.kafka.dto.ErrorDTO;
import com.email.kafka.exception.EmailsNotFoundException;
import com.email.kafka.exception.InvalidEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@ControllerAdvice
@RestController
@CrossOrigin
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmailsNotFoundException.class})
    public Object handleException(EmailsNotFoundException exception, Locale locale) {
        return ErrorDTO
                .builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidEmailException.class})
    public Object handleException(InvalidEmailException exception, Locale locale) {
        return ErrorDTO
                .builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
