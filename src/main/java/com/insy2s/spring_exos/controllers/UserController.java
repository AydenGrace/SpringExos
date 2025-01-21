package com.insy2s.spring_exos.controllers;

import com.insy2s.spring_exos.Entities.Task;
import com.insy2s.spring_exos.Entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    //Static map of users
    private static final Map<Integer, User> allUsers = new HashMap<>();


    //http://localhost:8081/user/all
    @GetMapping("/all")
    public ResponseEntity<Map<Integer,User>> getAllUsers(){
        return ResponseEntity.ok(allUsers);
    }

    //http://localhost:8081/user/1
    //http://localhost:8081/user/10
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id){
        if(id == null || allUsers.get(id)==null) return "Erreur : Utilisateur inconnu.";
        return "Utilisateur : "+allUsers.get(id);
    }

    @PostMapping("")
    public ResponseEntity<String> postUser(@RequestBody User user){
        allUsers.put(allUsers.size(),user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur ajoutée avec l'ID "+(allUsers.size()-1));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> putUser(@PathVariable Integer id, @RequestBody User user){
        if(id == null || allUsers.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (user.getEmail() == null) user.setEmail(allUsers.get(id).getEmail());
        if (user.getName() == null) user.setName(allUsers.get(id).getName());
        allUsers.put(id,user);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        if(id == null || allUsers.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allUsers.remove(id);
        return ResponseEntity.ok().build();
    }
}
