package com.insy2s.spring_exos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    //http://localhost:8081/add?a=5&b=7
    //http://localhost:8081/add?a=5
    //http://localhost:8081/add
    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b)
    {
        if(a == null) a = 0;
        if(b == null) b = 0;
        return ResponseEntity.ok("Résultat : "+(a+b));
    }

    //http://localhost:8081/multiply/5/8
    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<String> multiply(@PathVariable Integer a, @PathVariable Integer b){
        return ResponseEntity.ok("Résultat : "+(a*b));
    }
}
