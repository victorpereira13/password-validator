package com.validator.passwordvalidator.adapter.rest.controller;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResponse {

    private boolean valid;

}
