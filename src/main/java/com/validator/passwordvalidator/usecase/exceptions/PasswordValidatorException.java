package com.validator.passwordvalidator.usecase.exceptions;

public class PasswordValidatorException extends RuntimeException {
    public PasswordValidatorException(String message) {
        super(message);
    }
}
