package com.example.critiboxspring.repository;


import com.example.critiboxspring.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long > {
    void deleteReviewBySerie(String serie);
}
