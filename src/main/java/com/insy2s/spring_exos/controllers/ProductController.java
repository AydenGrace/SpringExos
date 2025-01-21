package com.insy2s.spring_exos.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Map<Integer, String> allProducts = new HashMap<>();

    //http://localhost:8081/product/all
    @GetMapping("/all")
    public Map<Integer,String> getAllProducts(){
        return allProducts;
    }

    //http://localhost:8081/product/add?name=Test
    //http://localhost:8081/product/add?name=Test2
    //http://localhost:8081/product/add?name=Test3
    @GetMapping("/add")
    public String postProduct(@RequestParam(value = "name") String name){
        try{
            allProducts.put(allProducts.size(), name);
            return "Produit '"+name+"' ajouté !";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //http://localhost:8081/product/0
    //http://localhost:8081/product/10
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id){
        if(id == null || allProducts.get(id) == null) return "Erreur : Produit introuvable.";
        return "Produit : "+allProducts.get(id);
    }
}
