package com.validator.passwordvalidator.adapter.rest.errorhandler;

import com.validator.passwordvalidator.adapter.rest.errorhandler.json.ApiErrorResponse;
import com.validator.passwordvalidator.entities.exceptions.PasswordException;
import com.validator.passwordvalidator.usecase.validatepassword.exceptions.PasswordValidatorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@ResponseBody
@ControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(value = {PasswordException.class, PasswordValidatorException.class})
    protected ResponseEntity<ApiErrorResponse> invalidPassword(final Exception e) {
        var status = HttpStatus.BAD_REQUEST;
        var msg = this.retrieveMessage(e);
        return buildResponseEntity(status, msg);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ApiErrorResponse> unexpectedError(final Exception e) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var msg = this.retrieveMessage(e);
        return buildResponseEntity(status, msg);
    }


    private ResponseEntity<ApiErrorResponse> buildResponseEntity(HttpStatus status, String message) {
        return new ResponseEntity<>(new ApiErrorResponse(status, message), status);
    }

    private String retrieveMessage(Exception e) {
        return Objects.isNull(e.getCause()) ? e.getLocalizedMessage() : e.getCause().getMessage();
    }
}
