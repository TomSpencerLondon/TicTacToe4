package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameMessageTest {

  @Autowired
  ObjectMapper mapper;

  @Test
  void displaySerializedJsonString() throws JsonProcessingException {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    GameController gameController = new GameController(gameService);

    GameMessage gameMessage = gameController.currentStateOfGame();

    String result = mapper.writeValueAsString(gameMessage);

    assertThat(result)
        .isEqualTo("""
            {"gameState":"PLAYER1TURN","board":[["_","_","_"],["_","_","_"],["_","_","_"]]}""");
  }
}