package com.validator.passwordvalidator.entities;


import com.validator.passwordvalidator.entities.exceptions.PasswordException;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
@Data
public class Password {
    private String password;

    public void setPassword(String password) {
        this.password = validateAttribute(password);
    }

    private String validateAttribute(String attribute) {
        if (Objects.isNull(attribute) || attribute.isBlank())
            throw new PasswordException("A senha não pode estar em branco");
        return attribute;
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