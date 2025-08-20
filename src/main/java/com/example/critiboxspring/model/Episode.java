package com.example.critiboxspring.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int episodeNumber;
    private int seasonNumber;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
    private LocalDate releaseDate;

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Episode(int seasonNumber, EpisodesData episodeData) {
        this.title = episodeData.title();
        this.episodeNumber = episodeData.episodeNumber();
        this.seasonNumber = seasonNumber;
        this.serie = serie;

        try {
            this.rating = Double.parseDouble(episodeData.rating());
        }catch (NumberFormatException ex){
            this.rating = 0.0;
        }

        try {
            this.releaseDate = LocalDate.parse(episodeData.releaseDate());
        }
        catch (DateTimeParseException ex){
            this.releaseDate = null;
        }
    }

    public Episode() {

    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "season='" + seasonNumber +
                ", title=" + title +
                ", episodeNumber=" + episodeNumber +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate;
    }
}
