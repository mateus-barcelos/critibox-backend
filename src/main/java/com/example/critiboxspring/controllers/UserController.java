package com.example.critiboxspring.controllers;


import com.example.critiboxspring.dto.UserDTO;
import com.example.critiboxspring.model.User;
import com.example.critiboxspring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;

    @GetMapping
    public List<UserDTO> getAllUser(){
        return service.getAllUsers().stream().map(UserDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = new User(userDTO);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}
