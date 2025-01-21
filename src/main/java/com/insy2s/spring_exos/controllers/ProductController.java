package com.insy2s.spring_exos.controllers;

import com.insy2s.spring_exos.Entities.Product;
import com.insy2s.spring_exos.Entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Map<Integer, Product> allProducts = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<Map<Integer,Product>> getAllProducts(){
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping("")
    public ResponseEntity<String> postProduct(@RequestBody Product body){
        allProducts.put(allProducts.size(),body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produit ajoutée avec l'ID "+(allProducts.size()-1));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> putProduct(@PathVariable Integer id, @RequestBody Product body){
        if(id == null || allProducts.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (body.getPrice() == -1) body.setPrice(allProducts.get(id).getPrice());
        if (body.getName() == null) body.setName(allProducts.get(id).getName());
        allProducts.put(id,body);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        if(id == null || allProducts.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allProducts.remove(id);
        return ResponseEntity.ok().build();
    }
}
