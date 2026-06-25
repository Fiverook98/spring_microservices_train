package com.demo.thymeleaf.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PostalCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostalCode {
    public String value() default "73";
    
    public String message() default "must start with 73";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
