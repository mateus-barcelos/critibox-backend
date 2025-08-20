package com.example.critiboxspring.controllers;



import com.example.critiboxspring.model.Review;
import com.example.critiboxspring.dto.ReviewDTO;
import com.example.critiboxspring.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getReviews(){
        return reviewService.getAllReviews().stream().map(ReviewDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO){
        Review review = new Review(reviewDTO);
        reviewService.saveReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serieId}")
    public ResponseEntity<Review> deleteByName(@PathVariable Long serieId){
        reviewService.deleteReviewById(serieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
