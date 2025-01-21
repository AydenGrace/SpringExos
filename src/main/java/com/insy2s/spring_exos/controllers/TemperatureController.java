package com.insy2s.spring_exos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    //http://localhost:8081/convert?celsius=52.1
    //http://localhost:8081/convert
    @GetMapping("/convert")
    public String convert(@RequestParam(value = "celsius", required = false) Double celsius){
        if(celsius==null) celsius=0.0;
        double fahrenheit = (celsius * (9.0/5.0))+32;
        return celsius+"°C = "+fahrenheit+"°F";
    }
}
