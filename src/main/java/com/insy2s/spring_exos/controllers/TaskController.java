package com.insy2s.spring_exos.controllers;

import com.insy2s.spring_exos.Entities.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Map<Integer, Task> allTasks = new HashMap<>();

    @PostMapping("")
    public ResponseEntity<String> postTask(@RequestBody Task task){
        allTasks.put(allTasks.size(),task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tâche ajoutée avec l'ID "+(allTasks.size()-1));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> putTask(@PathVariable Integer id, @RequestBody Task task){
        if(id == null || allTasks.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allTasks.put(id,task);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        if(id == null || allTasks.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allTasks.remove(id);
        return ResponseEntity.ok().build();
    }
}
