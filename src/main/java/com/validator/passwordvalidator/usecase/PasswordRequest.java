package com.validator.passwordvalidator.usecase;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequest {

    private String password;

}
