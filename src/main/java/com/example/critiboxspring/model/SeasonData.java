package com.example.critiboxspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonData(
             @JsonAlias("Season") int seasonNumber,
            @JsonAlias("Episodes") List<EpisodesData> episodes

) {
}
