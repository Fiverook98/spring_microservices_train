package com.exercise.itsreadydemo.controller;

import com.exercise.itsreadydemo.repo.TestFeign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItsReadyController {

    private final Logger log = LoggerFactory.getLogger(ItsReadyController.class);

    @Autowired
    private TestFeign test;

//    @GetMapping("ready")
//    @Retry(name = "ready", fallbackMethod = "readyFallback")
//    public ResponseEntity<String> ready(){
//        log.warn("Sto provando ad accedere al servizio StoreApplication >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        return test.itsReady();
//    }
    @GetMapping("ready")
//    @Retry(name = "default", fallbackMethod = "readyFallback")
    @CircuitBreaker(name = "default", fallbackMethod = "readyFallback")
    public String ready(){
        log.info("Sto provando ad accedere al servizio StoreApplication >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ResponseEntity<String> res = new RestTemplate().getForEntity("http://localhost:8081/itsReady", String.class );
        return res.getBody();
    }

    public String readyFallback(Exception e) {
        log.error("Il servizio StoreApplication non è pronto, fallback attivato >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "Il servizio StoreApplication non è pronto, riprova più tardi.";
    }

    @GetMapping("/imp")
    public ResponseEntity<String> getInstance() {
        return test.getInstance();
    }





}
