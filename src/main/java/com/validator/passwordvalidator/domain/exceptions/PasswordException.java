package com.validator.passwordvalidator.domain.exceptions;

public class PasswordException extends RuntimeException{
    public PasswordException(String message) {
        super(message);
    }
}
