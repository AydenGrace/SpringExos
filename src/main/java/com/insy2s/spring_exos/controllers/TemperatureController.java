package com.insy2s.spring_exos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    //http://localhost:8081/convert?celsius=52.1
    //http://localhost:8081/convert
    @GetMapping("/convert")
    public ResponseEntity<String> convert(@RequestParam(value = "celsius", required = false) Double celsius){
        if(celsius==null) celsius=0.0;
        double fahrenheit = (celsius * (9.0/5.0))+32;
        return ResponseEntity.ok(celsius+"°C = "+fahrenheit+"°F");
    }
}
