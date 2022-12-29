package com.mgshepherd.backend.controllers;

import com.mgshepherd.backend.errors.AlreadyExistsException;
import com.mgshepherd.backend.errors.InvalidJSONException;
import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.services.GameService;
import com.smattme.requestvalidator.RequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> validationErrors = RequestValidator.validate(game, getGameJSONRules());
        if (!validationErrors.isEmpty()) throw new InvalidJSONException();
        Game createdGame = gameService.addGame(game);
        if (createdGame == null) throw new AlreadyExistsException(game.getName());
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    private Map<String, String> getGameJSONRules() {
        Map<String, String> rules = new HashMap<>();
        rules.put("name", "required");
        rules.put("publisher", "required");
        rules.put("releaseDate", "required");
        rules.put("imageUrl", "required");
        rules.put("genre", "required");

        return rules;
    }
}
