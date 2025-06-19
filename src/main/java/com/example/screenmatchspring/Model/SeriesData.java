package com.example.screenmatchspring.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(
        String Title,
        @JsonAlias("totalSeasons") int seasons,
        @JsonAlias("imdbRating") String rating
) {
}
