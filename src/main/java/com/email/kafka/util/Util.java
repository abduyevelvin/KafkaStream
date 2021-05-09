package com.email.kafka.util;

import com.email.kafka.enums.InvalidEmailEnum;
import com.email.kafka.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    // regex for email
    private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public static boolean checkEmail(String email) {
        // initialize the Pattern object
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException(InvalidEmailEnum.INVALID_EMAIL);
        }

        return true;
    }

}
