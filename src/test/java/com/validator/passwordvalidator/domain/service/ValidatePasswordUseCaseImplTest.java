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

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class ValidatePasswordUseCaseImplTest {

    @Mock
    private IValidatePasswordUseCase validatePasswordUseCase;

    @InjectMocks
    private ValidatePasswordUseCaseImpl validatePasswordImpl;


    @Test
    public void whenValidateOk() {
        String password = "AbTp9!fok";
        var request = this.buildPasswordRequest();
        var expected = buildPasswordResponse();
        Mockito.when(validatePasswordImpl.validate(any())).thenReturn(true);
        var actual = true;
        Assert.assertEquals(expected, actual);
    }



    private PasswordRequest buildPasswordRequest() {
        return PasswordRequest.builder()
                .password("AbTp9!fok")
                .build();
    }

    private PasswordResponse buildPasswordResponse(){
        return PasswordResponse.builder()
                .valid(true)
                .build();
    }


}