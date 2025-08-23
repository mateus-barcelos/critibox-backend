package com.example.critiboxspring.controllers;



import com.example.critiboxspring.model.Review;
import com.example.critiboxspring.dto.ReviewDTO;
import com.example.critiboxspring.services.ReviewService;
import com.example.critiboxspring.services.UserService;
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
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ReviewDTO> getReviews(){
        return reviewService.getAllReviews().stream().map(ReviewDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO){
        Review review = new Review(reviewDTO);
        review.setUserOwner(userService.getUserById(reviewDTO.userOwnerId()).get());
        userService.getUserById(reviewDTO.userOwnerId()).get().addReview(review);
        reviewService.saveReview(review);
        return new ResponseEntity<>(reviewDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serieId}")
    public ResponseEntity<Review> deleteByName(@PathVariable Long serieId){
        reviewService.deleteReviewById(serieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
