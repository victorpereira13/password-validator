package com.validator.passwordvalidator.domain.service;


import com.validator.passwordvalidator.domain.Password;
import com.validator.passwordvalidator.usecase.exceptions.PasswordValidatorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceTest {

    @InjectMocks
    private ValidationService validateService;

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_WhenBlank(){
        validateService.validateBlank(Password.builder().password("Con tainsBlank").build());
    }
    @Test
    public void testValidate_WhenBlankOk(){
        validateService.validateBlank(Password.builder().password("NotContainsBlank").build());
    }

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_Length(){
        validateService.validateLength(Password.builder().password("Characte").build());
    }
    @Test
    public void testValidate_WhenLengthOk(){
        validateService.validateBlank(Password.builder().password("Character").build());
    }

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_ContainsNumber(){
        validateService.validateContainsNumber(Password.builder().password("ContainNumber").build());
    }

    @Test
    public void testValidate_WhenNumberOk(){
        validateService.validateContainsNumber(Password.builder().password("Character1").build());
    }

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_LowerCase(){
        validateService.validateLowerCase(Password.builder().password("LOWERCASE1").build());
    }

    @Test
    public void testValidate_WhenLowerCaseOk(){
        validateService.validateLowerCase(Password.builder().password("Character1").build());
    }

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_UpperCase(){
        validateService.validateUpperCase(Password.builder().password("uppercase1").build());
    }

    @Test
    public void testValidate_WhenUpperCaseOk(){
        validateService.validateUpperCase(Password.builder().password("Character1").build());
    }

    @Test(expected = PasswordValidatorException.class)
    public void testValidate_SpecialCharacters(){
        validateService.validateSpecialCharacters(Password.builder().password("Special11").build());
    }

    @Test
    public void testValidate_WhenSpecialCharacterOk(){
        validateService.validateSpecialCharacters(Password.builder().password("Character1!").build());
    }
    @Test(expected = PasswordValidatorException.class)
    public void testValidate_RepeatingCharacters(){
        validateService.validateRepeatingCharacters(Password.builder().password("Repeatping1!").build());
    }

    @Test
    public void testValidate_WhenRepeatinglCharacterOk(){
        validateService.validateRepeatingCharacters(Password.builder().password("AbTp9!fok").build());
    }


}