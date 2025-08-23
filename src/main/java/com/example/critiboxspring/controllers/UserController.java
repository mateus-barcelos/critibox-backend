package com.example.critiboxspring.controllers;


import com.example.critiboxspring.dto.UserDTO;
import com.example.critiboxspring.model.User;
import com.example.critiboxspring.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> getAllUser(){
        return service.getAllUsers().stream().map(UserDTO::new).toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        if(service.getUserById(id).isPresent()){
                UserDTO user = new UserDTO(service.getUserById(id).get());
                return new ResponseEntity<>(user,HttpStatus.FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = new User(userDTO);
        service.saveUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }


}
