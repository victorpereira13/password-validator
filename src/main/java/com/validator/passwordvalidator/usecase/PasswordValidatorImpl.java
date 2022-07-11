package com.validator.passwordvalidator.usecase;

import com.validator.passwordvalidator.entity.Password;
import com.validator.passwordvalidator.usecase.exceptions.PasswordValidatorException;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidatorImpl implements IPasswordValidator {


    @Override
    public boolean validate(String password) {
        var psw = Password.builder().password(password).build();
        // TODO: this.validateBlank é para especificar q é exatamente esse método
        this.validateBlank(psw);
        this.validateLength(psw);
        this.validateContainsNumber(psw);
        this.validateLowerCase(psw);
        this.validateUpperCase(psw);
        this.validateSpecialCharacters(psw);
        return true;
    }

    private void validateBlank(Password password) {
        var psw = password.getPassword().trim();
        if (psw.contains(" ")) throw new PasswordValidatorException("Password contains blank characters");
    }

    private void validateLength(Password password) {
        var psw = password.getPassword().trim();
        if (psw.length() < 9) throw new PasswordValidatorException("Password length is less than 9 characters");
    }

    private void validateContainsNumber(Password password) {
        var psw = password.getPassword().trim();
        // TODO check se contém digito
        if (!psw.matches(".*\\d.*")) throw new PasswordValidatorException("Password doesn't contain digits");
    }

    private void validateLowerCase(Password password) {
        var psw = password.getPassword().trim();
        // TODO .* pode estar em qualquer lugar da palavra
        if (!psw.matches(".*[a-z].*"))
            throw new PasswordValidatorException("Password doesn't contain lower case letters");
    }

    private void validateUpperCase(Password password) {
        var psw = password.getPassword().trim();
        if (!psw.matches(".*[A-Z].*"))
            throw new PasswordValidatorException("Password doesn't contain upper letters");
    }

    private void validateSpecialCharacters(Password password) {
        var psw = password.getPassword().trim();
        if (!psw.matches(".*[!@#$%^&*()-+]"))
            throw new PasswordValidatorException("Password doesn't contain special characters");
    }

}