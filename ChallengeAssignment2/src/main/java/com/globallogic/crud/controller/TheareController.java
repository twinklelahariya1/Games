package com.globallogic.crud.controller;


import com.globallogic.crud.model.Movie;
import com.globallogic.crud.model.Seat;
import com.globallogic.crud.model.Theatre;
import com.globallogic.crud.repository.MovieRepository;
import com.globallogic.crud.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheareController {

    @Autowired
    private TheatreRepository theatreRepository;

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatre(Theatre theatre) {
        return theatreRepository.findAll();
    }


    @PostMapping("/populateTheatres")
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreRepository.save(theatre);
    }
}
