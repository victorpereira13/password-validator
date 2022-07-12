package com.validator.passwordvalidator.usecase.validatepassword;

import com.validator.passwordvalidator.entities.Password;
import com.validator.passwordvalidator.usecase.validatepassword.exceptions.PasswordValidatorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidatePasswordUseCaseImpl implements IValidatePasswordUseCase {
    @Override
    public boolean validate(String password) {
        var psw = Password.builder().password(password).build();
        this.validateBlank(psw);
        this.validateLength(psw);
        this.validateContainsNumber(psw);
        this.validateLowerCase(psw);
        this.validateUpperCase(psw);
        this.validateSpecialCharacters(psw);
        this.validateRepeatingCharacters(psw);
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
        if (!psw.matches(".*[!@#$%^&*()-+].*"))
            throw new PasswordValidatorException("Password doesn't contain special characters");
    }

    private void validateRepeatingCharacters(Password password) {
        var psw = password.getPassword().trim();
        var chars = psw.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        if (chars.size() < psw.length())
            throw new PasswordValidatorException("Password contains repeating characters");
    }

}