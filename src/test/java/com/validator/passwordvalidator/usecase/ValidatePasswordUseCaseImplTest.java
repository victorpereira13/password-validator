package com.validator.passwordvalidator.usecase;

import com.validator.passwordvalidator.usecase.validatepassword.ValidatePasswordUseCaseImpl;
import com.validator.passwordvalidator.usecase.validatepassword.exceptions.PasswordValidatorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ValidatePasswordUseCaseImplTest {

    @InjectMocks
    private ValidatePasswordUseCaseImpl validatePasswordImpl;


    @Test
    public void whenValidateOk() {
        String password = "AbTp9!fok";
        Assert.assertEquals(true, validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateBlank() {
        String password = "Con tainsBlank";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateLength() {
        String password = "Characte";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateContainsNumber() {
        String password = "ContainNumber";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateLowerCase() {
        String password = "LOWERCASE1";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateUpperCase() {
        String password = "character1";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateSpecialCharacter() {
        String password = "Special11";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }

    @Test
    public void whenValidateRepeatingCharacter() {
        String password = "Repeatping1!";
        Assert.assertThrows(PasswordValidatorException.class, () -> validatePasswordImpl.validate(password));
    }


}