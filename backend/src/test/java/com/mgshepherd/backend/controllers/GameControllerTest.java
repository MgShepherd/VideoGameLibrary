package com.mgshepherd.backend.controllers;

import com.mgshepherd.backend.errors.AlreadyExistsException;
import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private final GameService mockService = Mockito.mock(GameService.class);
    private final Game testGame = new Game("TestGame", "TestPublisher", Date.valueOf("2022-12-23"), "https://www.google.co.uk", "Testing");
    private GameController gameController;

    @BeforeEach
    public void setupTests() {
        gameController = new GameController(mockService);
    }
    @Test
    @DisplayName("Get endpoint successfully fetches all games")
    public void getGamesEndpointTest() {
        when(mockService.getAllGames()).thenReturn(List.of(testGame));
        assertThat(gameController.getGames()).isEqualTo(List.of(testGame));
    }

    @Test
    @DisplayName("Create game endpoint returns 201 status when game is successfully created")
    public void createGameSuccessfulTest() {
        when(mockService.addGame(testGame)).thenReturn(testGame);

        ResponseEntity<Game> response = gameController.addGame(testGame);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(testGame);
    }

    @Test
    @DisplayName("Create game endpoint throws error if game already exists in the database")
    public void createGameUnsuccessfulTest() {
        when(mockService.addGame(testGame)).thenReturn(null);
        assertThrows(AlreadyExistsException.class, () -> {
            gameController.addGame(testGame);
        });
    }
}
