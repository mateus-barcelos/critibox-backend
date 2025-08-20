package com.example.critiboxspring.repository;

import com.example.critiboxspring.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleIgnoreCase(String title);
}
