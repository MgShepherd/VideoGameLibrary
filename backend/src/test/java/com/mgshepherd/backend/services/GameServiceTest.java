package com.mgshepherd.backend.services;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.models.GameID;
import com.mgshepherd.backend.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GameServiceTest {
    private GameRepository mockRepository = Mockito.mock(GameRepository.class);
    private GameService gameService;
    private Game testGame = new Game("TestGame", "TestPublisher", Date.valueOf("2022-12-23"), "https://www.google.co.uk", "Testing");

    @BeforeEach
    public void setupTests() {
        gameService = new GameService(mockRepository);
    }

    @Test
    @DisplayName("Get all games method returns all games from the database")
    public void getAllGamesTest() {
        when(mockRepository.findAll()).thenReturn(List.of(testGame));

        List<Game> response = gameService.getAllGames();
        assertThat(response).isEqualTo(List.of(testGame));

        assertThat(response.get(0).getName()).isEqualTo("TestGame");
        assertThat(response.get(0).getPublisher()).isEqualTo("TestPublisher");
        assertThat(response.get(0).getReleaseDate()).isEqualTo(Date.valueOf("2022-12-23"));
        assertThat(response.get(0).getImageUrl()).isEqualTo("https://www.google.co.uk");
        assertThat(response.get(0).getGenre()).isEqualTo("Testing");
    }

    @Test
    @DisplayName("Add game method returns added game when successfully added to the database")
    public void addGameSuccessfulTest() {
        when(mockRepository.findById(new GameID(testGame.getName(), testGame.getPublisher()))).thenReturn(Optional.empty());
        when(mockRepository.save(testGame)).thenReturn(testGame);

        Game response = gameService.addGame(testGame);
        assertThat(response).isEqualTo(testGame);
    }

    @Test
    @DisplayName("Add game method returns null object when game with same name and publisher already exists")
    public void addGameUnsuccessfulTest() {
        when(mockRepository.findById(new GameID(testGame.getName(), testGame.getPublisher()))).thenReturn(Optional.of(testGame));

        Game response = gameService.addGame(testGame);
        assertThat(response).isNull();
    }
}
