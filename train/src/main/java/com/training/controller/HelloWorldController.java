package com.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger((HelloWorldController.class));

    @GetMapping(value = "/logger")
    public ResponseEntity<String> hello(){
        logger.info(">>>>>> Hello World <<<<<<<");
        logger.debug(">>>>>> Hello Debug World <<<<<<<");

        return ResponseEntity.ok("Hello World");
    }
}
