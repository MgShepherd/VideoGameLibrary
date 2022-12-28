package com.mgshepherd.backend.controllers;

import com.mgshepherd.backend.errors.AlreadyExistsException;
import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @PostMapping(value="/addGame", consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game createdGame = gameService.addGame(game);
        if (createdGame == null) throw new AlreadyExistsException(game.getName());
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }
}
