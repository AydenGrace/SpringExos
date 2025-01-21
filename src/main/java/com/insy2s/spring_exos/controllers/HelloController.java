package com.insy2s.spring_exos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //http://localhost:8081/hello?name=Jean
    //http://localhost:8081/hello
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name){
        return "Bonjour, "+(name == null ? "Guest" : name)+" !";
    }
}
