package com.training.controller;


import com.training.Exception.DuplicateException;
import com.training.Exception.NotFoundException;
import com.training.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DuplicateException.class)
    public final ResponseEntity<ErrorResponse> exceptionDuplicateHandler(Exception ex){
        ErrorResponse error = new ErrorResponse();
        error.setCode(HttpStatus.CONFLICT.value());

        error.setMessage(((DuplicateException)ex).getMessaggio());
        return new ResponseEntity<ErrorResponse>(error, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception ex){
        ErrorResponse error = new ErrorResponse();
        error.setCode(HttpStatus.NOT_FOUND.value());

        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
