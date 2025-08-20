package com.example.critiboxspring;


import com.example.critiboxspring.repository.EpisodeRepository;
import com.example.critiboxspring.repository.ReviewRepository;
import com.example.critiboxspring.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class critiBoxApplication {
    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(critiBoxApplication.class, args);
    }

}