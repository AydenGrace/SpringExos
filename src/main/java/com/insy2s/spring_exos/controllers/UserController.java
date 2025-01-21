package com.insy2s.spring_exos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {
    //Static map of users
    private static final Map<Integer, String> allUsers;
    static {
        Map<Integer, String> initMap = new HashMap<>();
        initMap.put(1, "Fethi");
        initMap.put(2, "Pierre-Alex");
        initMap.put(3, "Lorry");
        initMap.put(4, "Le");
        initMap.put(5, "Michael");
        allUsers = new HashMap<>(initMap);
    }

    //http://localhost:8081/user/all
    @GetMapping("/user/all")
    public ResponseEntity<List<String>> getAllUsers(){
        List<String> list = new ArrayList<>();
        for (Integer integer : allUsers.keySet()) {
            list.add(allUsers.get(integer));
        }
        return ResponseEntity.ok(list);
    }

    //http://localhost:8081/user/1
    //http://localhost:8081/user/10
    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Integer id){
        if(id == null || allUsers.get(id)==null) return ResponseEntity.status(404).body("Erreur : Utilisateur inconnu.");
        return ResponseEntity.ok("Utilisateur : "+allUsers.get(id));
    }
}
