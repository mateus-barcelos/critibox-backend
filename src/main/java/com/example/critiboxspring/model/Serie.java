package com.example.critiboxspring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer seasons;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private Category genre;
    private String actors;
    private String poster;
    @OneToMany(mappedBy = "serie")
    private List<Episode> episodes = new ArrayList<>();
    private String plot;



    public Serie(SeriesData seriesData){
        this.title = seriesData.title();
        this.seasons = seriesData.seasons();
        this.rating = OptionalDouble.of(Double.valueOf(seriesData.rating())).orElse(0);
        this.genre = Category.fromString(seriesData.genre().split(",")[0].trim());
        this.actors = seriesData.actors();
        this.poster = seriesData.poster();
        this.plot = seriesData.plot().trim();

    }

    public Serie() {

    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return
                "titulo=" + title +
                        ", genero='" + genre + '\'' +
                        ", totalTemporadas=" + seasons +
                        ", avaliacao=" + rating +
                        ", atores='" + actors + '\'' +
                        ", poster='" + poster + '\'' +
                        ", sinopse='" + plot + '\'';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
