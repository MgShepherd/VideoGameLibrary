package com.mgshepherd.backend.services;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.models.GameID;
import com.mgshepherd.backend.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game addGame(Game newGame) {
        if (alreadyExists(newGame)) return null;
        return gameRepository.save(newGame);
    }

    private boolean alreadyExists(Game game) {
        return gameRepository.findById(new GameID(game.getName(), game.getPublisher())).isPresent();
    }
}
