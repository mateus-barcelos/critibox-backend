package com.example.critiboxspring.controllers;

import com.example.critiboxspring.dto.SerieDTO;
import com.example.critiboxspring.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;

    @GetMapping
    public List<SerieDTO> showSeries(){
        return service.listQueriedSeries().stream().map(SerieDTO::new).toList();
    }

    @PostMapping("/{serieName}")
    public void querySerie(@PathVariable String serieName){
        service.queryWebSerie(serieName);

    }

    @DeleteMapping("/{serieName}")
    public ResponseEntity<Void> deleteSerieByName(@PathVariable String serieName){
        service.deleteSerieByName(serieName);
        return ResponseEntity.ok().build();
    }
}
