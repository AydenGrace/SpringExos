package com.insy2s.spring_exos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private static final Map<Integer, String> allProducts = new HashMap<>();

    //http://localhost:8081/product/all
    @GetMapping("/product/all")
    public ResponseEntity<List<String>> getAllProducts(){
        List<String> p = new ArrayList<>();
        for (Integer i : allProducts.keySet()) {
            p.add(allProducts.get(i));
        }
        return ResponseEntity.ok(p);
    }

    //http://localhost:8081/product/add?name=Test
    //http://localhost:8081/product/add?name=Test2
    //http://localhost:8081/product/add?name=Test3
    @GetMapping("/product/add")
    public ResponseEntity<String> putProduct(@RequestParam(value = "name") String name){
        try{
            allProducts.put(allProducts.size(), name);
            return ResponseEntity.ok("Produit '"+name+"' ajouté !");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    //http://localhost:8081/product/1
    //http://localhost:8081/product/10
    @GetMapping("/product/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Integer id){
        if(id == null || allProducts.get(id) == null) return ResponseEntity.status(404).body("Erreur : Produit introuvable.");
        return ResponseEntity.ok("Produit : "+allProducts.get(id));
    }
}
