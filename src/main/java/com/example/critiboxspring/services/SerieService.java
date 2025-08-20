package com.example.critiboxspring.services;

import com.example.critiboxspring.model.Episode;
import com.example.critiboxspring.model.SeasonData;
import com.example.critiboxspring.model.Serie;
import com.example.critiboxspring.model.SeriesData;
import com.example.critiboxspring.repository.EpisodeRepository;
import com.example.critiboxspring.repository.SerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService {
    private SerieRepository serieRepository;
    private EpisodeRepository episodeRepository;
    private OmdbService apiRequest = new OmdbService();
    private DesserializerData converter = new DesserializerData();

    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=18310914";

    public SerieService(SerieRepository serieRepository, EpisodeRepository episodeRepository) {
        this.serieRepository = serieRepository;
        this.episodeRepository = episodeRepository;
    }

    public void queryWebSerie(String serieName) {
        SeriesData data = getSerieData(serieName);
        List<SeasonData> seasons = new ArrayList<>();
        List<Episode> episodes = new ArrayList<>();
        Serie serie = new Serie(data);

        for (int i = 1; i <= data.seasons(); i++) {
            var json = apiRequest.requestData(URL + data.title().replace(" ", "+") + "&season=" + i + API_KEY);
            SeasonData seasonData = converter.desserializer(json, SeasonData.class);
            seasons.add(seasonData);
        }

        seasons.forEach(s -> s.episodes()
                .forEach(e-> episodes.add(new Episode(s.seasonNumber(),e))));
        serie.setEpisodes(episodes);
        serieRepository.save(serie);
        episodes.forEach(e -> e.setSerie(serie));
        episodeRepository.saveAll(episodes);

    }

    private SeriesData getSerieData(String serieName) {
        var json = apiRequest.requestData(URL + serieName.replace(" ", "+") + API_KEY);
        SeriesData data = converter.desserializer(json, SeriesData.class);
        return data;
    }

//    public void queryEpisodeBySerie(){
//        SeriesData seriesData = getSerieData();
//        List<SeasonData> seasons = new ArrayList<>();
//
//        for (int i = 1; i <= seriesData.seasons(); i++) {
//            var json = apiRequest.requestData(URL + seriesData.title().replace(" ", "+") + "&season=" + i + API_KEY);
//            SeasonData seasonData = converter.desserializer(json, SeasonData.class);
//            seasons.add(seasonData);
//        }
//        seasons.forEach(System.out::println);
//    }
    @Transactional
    public void deleteSerieByName(String serieName){
        Long serieId;
        var serieQuery = serieRepository.findByTitleIgnoreCase(serieName);

        if (serieQuery.isPresent()) {
            serieId = serieQuery.get().getId();
            episodeRepository.deleteAllBySerie_Id(serieId);
            serieRepository.deleteById(serieId);
        }
        else
            System.out.println("Nenhuma série com esse nome está salva!");

    }

    public List<Serie> listQueriedSeries(){
       return serieRepository.findAll();
    }

    public SerieRepository getSerieRepository() {
        return serieRepository;
    }

    public void setSerieRepository(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }
}

