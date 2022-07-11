package com.validator.passwordvalidator.domain.service;

import com.validator.passwordvalidator.domain.Password;
import com.validator.passwordvalidator.usecase.exceptions.PasswordValidatorException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    public void validateBlank(Password password) {
        var psw = password.getPassword().trim();
        if (psw.contains(" ")) throw new PasswordValidatorException("Password contains blank characters");
    }

    public void validateLength(Password password) {
        var psw = password.getPassword().trim();
        if (psw.length() < 9) throw new PasswordValidatorException("Password length is less than 9 characters");
    }

    public void validateContainsNumber(Password password) {
        var psw = password.getPassword().trim();
        // TODO check se contém digito
        if (!psw.matches(".*\\d.*")) throw new PasswordValidatorException("Password doesn't contain digits");
    }

    public void validateLowerCase(Password password) {
        var psw = password.getPassword().trim();
        // TODO .* pode estar em qualquer lugar da palavra
        if (!psw.matches(".*[a-z].*"))
            throw new PasswordValidatorException("Password doesn't contain lower case letters");
    }

    public void validateUpperCase(Password password) {
        var psw = password.getPassword().trim();
        if (!psw.matches(".*[A-Z].*"))
            throw new PasswordValidatorException("Password doesn't contain upper letters");
    }

    public void validateSpecialCharacters(Password password) {
        var psw = password.getPassword().trim();
        if (!psw.matches(".*[!@#$%^&*()-+].*"))
            throw new PasswordValidatorException("Password doesn't contain special characters");
    }

    public void validateRepeatingCharacters(Password password) {
        var psw = password.getPassword().trim();
        var chars = psw.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        if(chars.size()<psw.length())
            throw new PasswordValidatorException("Password contains repeating characters");
    }
}
