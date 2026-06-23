package com.vti.validation.account;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameNotExistsValidator implements ConstraintValidator<UsernameNotExists, String> {

    @Autowired

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(s)){
            return true;
        }
        return false;
    }
}
