package com.example.critiboxspring.services;

import com.example.critiboxspring.model.Review;
import com.example.critiboxspring.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository repository;

    public ReviewService (ReviewRepository repository){
        this.repository = repository;
    }

    public void saveReview(Review review){
        repository.save(review);
    }

    public List<Review> getAllReviews(){
      return repository.findAll();
    }

    public void deleteReviewById(Long id) {
        repository.deleteById(id);
    }
}
