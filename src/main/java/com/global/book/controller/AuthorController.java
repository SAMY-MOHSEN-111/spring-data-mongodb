package com.global.book.controller;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") @Email String email) {
        return ResponseEntity.ok(authorService.findByEmail(email));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<?> updateEmail(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @PathVariable("email") String email
    ) {
        authorService.updateEmail(email, name, phone);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
