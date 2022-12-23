package com.mgshepherd.backend.services;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GameServiceTest {
    private GameRepository mockRepository = Mockito.mock(GameRepository.class);
    private GameService gameService;
    private Game testGame = new Game(1, "TestGame", "TestPublisher", Date.valueOf("2022-12-23"), "Testing");

    @BeforeEach
    public void setupTests() {
        gameService = new GameService(mockRepository);
    }

    @Test
    public void getAllGamesTest() {
        when(mockRepository.findAll()).thenReturn(List.of(testGame));
        assertThat(gameService.getAllGames()).isEqualTo(List.of(testGame));
    }
}
