package com.java.spring.security.error.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ConfigValidator implements ConstraintValidator<Config, String> {

    List<String> config = Arrays.asList("intel core i5", "intel core i7", "intel core i3", "intel core i10");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return config.contains(value);

    }
}
