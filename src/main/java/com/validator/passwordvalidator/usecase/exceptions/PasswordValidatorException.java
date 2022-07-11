package com.validator.passwordvalidator.usecase.exceptions;

import com.validator.passwordvalidator.entity.exceptions.PasswordException;

public class PasswordValidatorException extends RuntimeException {
    public PasswordValidatorException(String message) {
        super(message);
    }
}
