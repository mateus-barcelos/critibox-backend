package com.example.critiboxspring.dto;

import com.example.critiboxspring.model.Review;

public record ReviewDTO (String serie, String reviewText, double rating) {
    public ReviewDTO(Review review){
        this(review.getSerie(), review.getReviewText(), review.getRating());
    }
}
