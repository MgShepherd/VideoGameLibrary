package com.mgshepherd.backend.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.repositories.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private final Game testGame = new Game("TestGame", "TestPublisher", Date.valueOf("2022-12-23"), "https://www.google.co.uk", "Testing");

    @Test
    @DisplayName("Can Successfully insert a new game and then retrieve all games which should contain the new game")
    public void addAndGetSuccessful() throws Exception {
        ResultActions postResult = mockMvc.perform(post("/addGame")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testGame)));

        postResult.andExpect(status().isCreated());

        ResultActions getResult = mockMvc.perform(get("/games"));

        getResult.andExpect(status().isOk());
        getResult.andExpect(jsonPath("$[-1].name", is("TestGame")));
        getResult.andExpect(jsonPath("$[-1].publisher", is("TestPublisher")));
        getResult.andExpect(jsonPath("$[-1].releaseDate", is("2022-12-23")));
        getResult.andExpect(jsonPath("$[-1].imageUrl", is("https://www.google.co.uk")));
        getResult.andExpect(jsonPath("$[-1].genre", is("Testing")));
    }

    @Test
    @DisplayName("Attempting to insert a game which already exists in the DB should return an error")
    public void addAlreadyAdded() throws Exception {
        ResultActions postResult = mockMvc.perform(post("/addGame")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testGame)));

        postResult.andExpect(jsonPath("$.status", is("CONFLICT")));
        postResult.andExpect(jsonPath("$.error", is("TestGame already exists in the database")));
    }

    @Test
    @DisplayName("Attempting to insert a game with the incorrect JSON format should return an error")
    public void addInvalidJson() throws Exception {
        ResultActions postResult = mockMvc.perform(post("/addGame")
                .contentType("application/json")
                .content("{\"name\": \"Test\"}"));

        postResult.andExpect(jsonPath("$.status", is("BAD_REQUEST")));
        postResult.andExpect(jsonPath("$.error", is("Supplied JSON does not have correct format")));
    }
}
