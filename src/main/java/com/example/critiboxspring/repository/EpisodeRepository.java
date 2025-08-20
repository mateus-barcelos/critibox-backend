package com.example.critiboxspring.repository;

import com.example.critiboxspring.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    void deleteAllBySerie_Id(Long serieId);
}
