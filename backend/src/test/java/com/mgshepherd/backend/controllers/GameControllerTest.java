package com.mgshepherd.backend.controllers;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private GameService mockService = Mockito.mock(GameService.class);
    private GameController gameController;

    private Game testGame = new Game(1, "TestGame", "TestPublisher", Date.valueOf("2022-12-23"), "Testing");

    @BeforeEach
    public void setupTests() {
        gameController = new GameController(mockService);
    }

    @Test
    public void getGamesEndpointTest() {
        when(mockService.getAllGames()).thenReturn(List.of(testGame));
        assertThat(gameController.getGames()).isEqualTo(List.of(testGame));
    }
}
