package com.mgshepherd.backend.controllers;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getGames() {
        return gameRepository.findAll();
    }
}
