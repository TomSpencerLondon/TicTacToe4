package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;

class GameControllerTest {

  @Test
  void givenOneConnectionThenRequestForCurrentStateOfGameReturnsWaitingForPlayerTwo() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    GameController gameController = new GameController(gameService);

    GameMessage gameMessage = gameController.currentStateOfGame();

    assertThat(gameMessage.getGameState()).isEqualTo("WAITING_FOR_PLAYER2");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  @Test
  void givenTwoConnectionThenRequestForCurrentStateOfGameReturnsCurrentGameState() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    GameController gameController = new GameController(gameService);

    GameMessage gameMessage = gameController.currentStateOfGame();

    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }
}