package com.example.screenmatchspring.Model;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private String title;
    private int episodeNumber;
    private int seasonNumber;
    private double rating;
    private LocalDate releaseDate;

    public Episode(int seasonNumber, EpisodesData episodeData) {
        this.title = episodeData.title();
        this.episodeNumber = episodeData.episodeNumber();
        this.seasonNumber = seasonNumber;

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
