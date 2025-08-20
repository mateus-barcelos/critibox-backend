package com.example.critiboxspring.dto;

import com.example.critiboxspring.model.Episode;

public record EpisodeDTO ( String episodeTitle, int episodeNumber, int seasonNumber ) {
    public EpisodeDTO(Episode episode){
        this(episode.getTitle(), episode.getEpisodeNumber(), episode.getSeasonNumber());
    }
}
