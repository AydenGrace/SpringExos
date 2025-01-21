package com.insy2s.spring_exos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
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
    @GetMapping("/all")
    public Map<Integer,String> getAllUsers(){
        return allUsers;
    }

    //http://localhost:8081/user/1
    //http://localhost:8081/user/10
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id){
        if(id == null || allUsers.get(id)==null) return "Erreur : Utilisateur inconnu.";
        return "Utilisateur : "+allUsers.get(id);
    }
}
