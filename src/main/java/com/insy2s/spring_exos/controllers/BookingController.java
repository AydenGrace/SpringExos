package com.insy2s.spring_exos.controllers;

import com.insy2s.spring_exos.Entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private static final Map<Integer, Book> allBooks = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<Map<Integer,Book>> getAllBooks(){
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping("")
    public ResponseEntity<String> postBook(@RequestBody Book body){
        allBooks.put(allBooks.size(),body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Réservation confirmée avec l'ID "+(allBooks.size()-1));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Void> putBook(@PathVariable Integer id, @RequestBody Book body){
        if(id == null || allBooks.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (body.getRoom() == null) body.setRoom(allBooks.get(id).getRoom());
        if (body.getDate() == null) body.setDate(allBooks.get(id).getDate());
        allBooks.put(id,body);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        if(id == null || allBooks.get(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        allBooks.remove(id);
        return ResponseEntity.ok().build();
    }
}
