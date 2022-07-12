package com.validator.passwordvalidator.domain.service;


import com.validator.passwordvalidator.adapter.rest.controller.PasswordRequest;
import com.validator.passwordvalidator.adapter.rest.controller.PasswordResponse;
import com.validator.passwordvalidator.usecase.IValidatePasswordUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ValidationServiceTest {

    @Mock
    private IValidatePasswordUseCase passwordValidator;

    @InjectMocks
    private ValidatePasswordUseCaseImpl validatePasswordImpl;

    @InjectMocks
    private ValidationService validateService;


    public void validateBlank (){

    }


}