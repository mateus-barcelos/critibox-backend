package com.example.screenmatchspring.Main;

import com.example.screenmatchspring.Model.Episode;
import com.example.screenmatchspring.Model.EpisodesData;
import com.example.screenmatchspring.Model.SeasonData;
import com.example.screenmatchspring.Model.SeriesData;
import com.example.screenmatchspring.services.DesserializerData;
import com.example.screenmatchspring.services.OmdbService;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private OmdbService apiRequest = new OmdbService();
    private DesserializerData converter = new DesserializerData();

    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=18310914";

    public void menu() {
        System.out.println("Digite o nome da série para busca");
        var queryName = scanner.nextLine();
        var json = apiRequest.requestData(URL + queryName.replace(" ", "+") + API_KEY);
        SeriesData data = converter.desserializer(json, SeriesData.class);
        System.out.println(data);

        List<SeasonData> seasons = new ArrayList<>();

        for (int i = 1; i <= data.seasons(); i++) {
            json = apiRequest.requestData(URL + queryName.replace(" ", "+") + "&season=" + i + API_KEY);
            SeasonData seasonData = converter.desserializer(json, SeasonData.class);
            seasons.add(seasonData);
        }
        seasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

        List<EpisodesData> episodesData = seasons.stream()
                .flatMap(s -> s.episodes().stream())
                .collect(Collectors.toList());


        System.out.println("Top 5 episódios");
        episodesData.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodesData::rating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodes = seasons.stream()
                .flatMap(s -> s.episodes().stream()
                        .map(ed -> new Episode(s.seasonNumber(), ed)))
                .collect(Collectors.toList());

       episodes.forEach(System.out::println);

        System.out.println("Digite um trecho do episodio para buscar: ");
        String episodeQuery = scanner.nextLine();

        Optional<Episode> episodeFounded = episodes.stream()
                .filter(e -> e.getTitle().toUpperCase().contains(episodeQuery.toUpperCase()))
                .findAny();

        if(episodeFounded.isPresent()) {
            System.out.println("Episodio encontrado");
            System.out.println("Temporada: " + episodeFounded.get().getSeasonNumber());
            System.out.println("Episodio: " + episodeFounded.get().getEpisodeNumber());
        }else{
            System.out.println("Episodio não encontrado");
        }

        Map<Integer, Double> seasonRating = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeasonNumber,
                        Collectors.averagingDouble(Episode::getRating)));

        System.out.println(seasonRating);

        DoubleSummaryStatistics statistics = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));

        System.out.println("Total episódios: " + statistics.getCount());
        System.out.println("Melhor episódio: " + statistics.getMax());
        System.out.println("Pior episódio: " + statistics.getMin());


    }





}