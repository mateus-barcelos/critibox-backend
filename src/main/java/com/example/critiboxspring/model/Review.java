package com.example.critiboxspring.model;


import com.example.critiboxspring.dto.ReviewDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "serieReview")
public class Review {
    private String serie;
    private String reviewText;
    private double rating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User userOwner;


    public Review(ReviewDTO reviewDTO){
        this.serie = reviewDTO.serie();
        this.reviewText = reviewDTO.reviewText();
        this.rating = reviewDTO.rating();
    }

    public Review() {

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getSerie() {
        return serie;
    }
//
//    public void setSerie(Serie serie) {
//        this.serie = serie;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
