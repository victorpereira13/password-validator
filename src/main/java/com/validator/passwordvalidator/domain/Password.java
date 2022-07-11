package com.validator.passwordvalidator.domain;


import com.validator.passwordvalidator.domain.exceptions.PasswordException;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class Password {
    private String password;

    public void setPassword(String password) {
        validateAttribute(password);
        this.password = password;
    }

    private void validateAttribute(String attribute) {
     // TODO: para não tomar nullpointer
        if (Objects.isNull(attribute) || attribute.isBlank())
            throw new PasswordException("A senha não pode estar em branco");
    }

    public Password(String password) {
        setPassword(password);
    }

    public static class PasswordBuilder {
        public Password build() {
            return new Password(
                    password
            );
        }
    }

}