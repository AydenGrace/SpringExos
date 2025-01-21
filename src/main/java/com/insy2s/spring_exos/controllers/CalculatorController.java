package com.insy2s.spring_exos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b)
    {
        if(a == null) a = 0;
        if(b == null) b = 0;
        return "Résultat : "+(a+b);
    }

    @GetMapping("/multiply/{a}/{b}")
    public String multiply(@PathVariable Integer a, @PathVariable Integer b){
        return "Résultat : "+(a*b);
    }
}
