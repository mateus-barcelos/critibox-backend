package com.example.critiboxspring.dto;

import com.example.critiboxspring.model.Serie;

import java.util.List;

public record SerieDTO(String title, String actors, Integer seasons, Double rating, String posterUri, List<EpisodeDTO> episodes) {
    public SerieDTO(Serie serie){
        this(serie.getTitle(),serie.getActors(),serie.getSeasons(), serie.getRating(), serie.getPoster(), serie.getEpisodes().stream().map(EpisodeDTO::new).toList());
    }
}
