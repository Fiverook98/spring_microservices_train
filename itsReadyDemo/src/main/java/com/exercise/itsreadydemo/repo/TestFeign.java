package com.exercise.itsreadydemo.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("StoreApplication")
public interface TestFeign {

    @GetMapping("/itsReady")
    public ResponseEntity<String> itsReady();

    @GetMapping("/instance")
    public ResponseEntity<String> getInstance();
}
