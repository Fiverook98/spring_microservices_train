package com.demo.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PostalCodeConstraintValidator implements ConstraintValidator<PostalCode, String> {

    private String postalPrefix;

    @Override
    public void initialize(PostalCode postalCodeAnnotation){
        postalPrefix = postalCodeAnnotation.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context){
        if ( code != null) return code.startsWith(postalPrefix);
        return true;
    }
}
