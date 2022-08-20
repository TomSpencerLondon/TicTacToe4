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

    GameMessage gameMessage = gameController.currentStateOfGame();

    assertThat(gameMessage.getGameState())
        .isEqualTo("WAITING_FOR_PLAYER2");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{
            {"_", "_", "_"},
            {"_", "_", "_"},
            {"_", "_", "_"}
        });
  }

//  @Test
//  void secondWebSocketRequestForCurrentStateOfGameReturnsCurrentGameState() {
//    GameService gameService = new GameService(new TicTacToe());
//    GameController gameController = new GameController(gameService);
//    gameController.currentStateOfGame();
//
//    String message = gameController.currentStateOfGame();
//
//
//  }
}