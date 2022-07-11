package com.validator.passwordvalidator.adapter.rest.controller;


import com.validator.passwordvalidator.usecase.IValidatePasswordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("password")
@RequiredArgsConstructor
public class Controller {

    private final IValidatePasswordUseCase passwordValidator;


    @PostMapping("/validate")
    public ResponseEntity<PasswordResponse> validatePassword(@RequestBody PasswordRequest request) {
        boolean isOk = passwordValidator.validate(request.getPassword());
        return ResponseEntity.ok(PasswordResponse.builder().valid(isOk).build());
    }



}

