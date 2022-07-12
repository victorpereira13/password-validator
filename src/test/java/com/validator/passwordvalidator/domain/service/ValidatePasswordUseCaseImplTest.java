package com.validator.passwordvalidator.domain.service;

import com.validator.passwordvalidator.adapter.rest.controller.PasswordRequest;
import com.validator.passwordvalidator.adapter.rest.controller.PasswordResponse;
import com.validator.passwordvalidator.domain.Password;
import com.validator.passwordvalidator.usecase.IValidatePasswordUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class ValidatePasswordUseCaseImplTest {

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private ValidatePasswordUseCaseImpl validatePasswordImpl;


    @Test
    public void whenValidateOk() {
        String password = "AbTp9!fok";
        Password expectedPassword = new Password(password);
        validatePasswordImpl.validate(password);
        Mockito.verify(validationService, times(1)).validateBlank(expectedPassword);
        Mockito.verify(validationService, times(1)).validateLength(expectedPassword);
    }


}