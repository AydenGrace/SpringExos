package com.insy2s.spring_exos.controllers;

import com.insy2s.spring_exos.Entities.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Map<Integer, Post> allPosts = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<Map<Integer,Post>> getAllPosts(){
        return ResponseEntity.ok(allPosts);
    }

    @PostMapping("")
    public ResponseEntity<String> postPost(@RequestBody Post body){
        allPosts.put(allPosts.size(),body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Réservation confirmée avec l'ID "+(allPosts.size()-1));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> putPost(@PathVariable Integer id, @RequestBody Post body){
        if(id == null || allPosts.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (body.getTitle() == null) body.setTitle(allPosts.get(id).getTitle());
        if (body.getContent() == null) body.setContent(allPosts.get(id).getContent());
        allPosts.put(id,body);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePost(@PathVariable Integer id){
        if(id == null || allPosts.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allPosts.remove(id);
        return ResponseEntity.ok().build();
    }
}
