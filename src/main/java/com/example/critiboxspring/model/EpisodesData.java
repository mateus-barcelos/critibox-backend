package com.example.critiboxspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodesData(
        @JsonAlias("Title") String title,
        @JsonAlias("Episode")  int episodeNumber,
        @JsonAlias("imdbRating")  String rating,
        @JsonAlias("Released")  String releaseDate

) {
}
