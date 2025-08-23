package com.example.critiboxspring.dto;

import com.example.critiboxspring.model.Review;
import com.example.critiboxspring.model.User;

public record ReviewDTO (String serie, String reviewText, double rating, Long userOwnerId) {
    public ReviewDTO(Review review){
        this(review.getSerie(), review.getReviewText(), review.getRating(),review.getUserOwner().getId());
    }
}
