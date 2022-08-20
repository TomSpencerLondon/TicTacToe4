package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;

class GameControllerTest {

  @Test
  void firstWebSocketRequestForCurrentStateOfGameReturnsWaitingForPlayerTwo() {
    GameService gameService = new GameService(new TicTacToe());
    GameController gameController = new GameController(gameService);

    String message = gameController.currentStateOfGame();

    assertThat(message)
        .isEqualTo("Waiting for player 2");
  }
}