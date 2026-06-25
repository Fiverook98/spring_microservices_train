package com.demo.thymeleaf.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class memberValidator {

    /**
     * Return trimmed string using native method of spring.
     * If the string are only white spaces the return are null.
     * It allows us to validate data in Controller.
     */

    @InitBinder
    public void trimBinderForName(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
