package com.validator.passwordvalidator.domain.service;

import com.validator.passwordvalidator.domain.Password;
import com.validator.passwordvalidator.usecase.IPasswordValidator;
import com.validator.passwordvalidator.usecase.exceptions.PasswordValidatorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordValidatorImpl implements IPasswordValidator {
    private final ValidationService validationService;

    @Override
    public boolean validate(String password) {
        var psw = Password.builder().password(password).build();
        validationService.validateBlank(psw);
        validationService.validateLength(psw);
        validationService.validateContainsNumber(psw);
        validationService.validateLowerCase(psw);
        validationService.validateUpperCase(psw);
        validationService.validateSpecialCharacters(psw);
        validationService.validateRepeatingCharacters(psw);
        return true;
    }

}