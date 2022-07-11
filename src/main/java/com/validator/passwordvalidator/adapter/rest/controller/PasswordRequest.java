package com.validator.passwordvalidator.adapter.rest.controller;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequest {

    private String password;

}
