package com.validator.passwordvalidator.adapter.rest.controller;

import com.validator.passwordvalidator.usecase.validatepassword.IValidatePasswordUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private IValidatePasswordUseCase passwordValidator;

    @InjectMocks
    private Controller controller;


    @Test
    public void whenControllerOk() {
        String password = "AbTp9!fok";
        var expected = ResponseEntity.ok(PasswordResponse.builder().valid(true).build());
        Mockito.when(passwordValidator.validate(password)).thenReturn(true);
        var actual = controller.validatePassword(PasswordRequest.builder().password(password).build());
        Mockito.verify(passwordValidator, times(1)).validate(password);
        Assert.assertEquals(expected, actual);
    }

}