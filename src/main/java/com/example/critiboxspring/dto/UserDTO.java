package com.example.critiboxspring.dto;

import com.example.critiboxspring.model.User;

import java.util.List;

public record UserDTO (String username, List<ReviewDTO> reviews){
    public UserDTO(User user){
        this(user.getUsername(),user.getReviews().stream().map(ReviewDTO::new).toList());
    }
}