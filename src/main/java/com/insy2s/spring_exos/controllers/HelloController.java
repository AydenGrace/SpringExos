package com.insy2s.spring_exos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //http://localhost:8081/hello?name=Jean
    //http://localhost:8081/hello
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) String name){
        return ResponseEntity.ok("Bonjour, "+(name == null ? "Guest" : name)+" !");
    }
}
