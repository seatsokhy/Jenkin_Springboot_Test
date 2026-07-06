package com.example.Homework.controller;

import com.example.Homework.model.User;
import com.example.Homework.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService ) {
        this.userService = userService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/hello")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("<h1>hello this is work</h1>");
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }
}
