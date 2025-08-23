package com.example.critiboxspring.services;

import com.example.critiboxspring.model.User;
import com.example.critiboxspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public void deleteUserById(Long id){
        repository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }
}
