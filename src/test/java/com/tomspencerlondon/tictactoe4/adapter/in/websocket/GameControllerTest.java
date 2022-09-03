package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.support.GenericMessage;

class GameControllerTest {

  @Test
  void givenOneConnectionThenRequestForCurrentStateOfGameReturnsWaitingForPlayerTwo() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    GameController gameController = new GameController(gameService);
    PlayerPayload playerPayload = new PlayerPayload("connect", "", 1);
    GenericMessage<PlayerPayload> message = new GenericMessage<>(playerPayload);

    GameMessage gameMessage = gameController.currentStateOfGame(message);

    assertThat(gameMessage.getGameState()).isEqualTo("WAITING_FOR_PLAYER2");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  @Test
  void givenTwoConnectionsThenRequestForCurrentStateOfGameReturnsPlayerOneTurnWithEmptyBoard() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    GameController gameController = new GameController(gameService);
    PlayerPayload playerPayload = new PlayerPayload("connect", "", 2);
    GenericMessage<PlayerPayload> message = new GenericMessage<>(playerPayload);

    GameMessage gameMessage = gameController.currentStateOfGame(message);

    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  @Test
  void givenPlayerOneTurnThenRequestReturnsPlayerTwoTurnAndUpdatedBoard() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    GameController gameController = new GameController(gameService);
    PlayerPayload playerPayload = new PlayerPayload("play", "0", 1);
    GenericMessage<PlayerPayload> message = new GenericMessage<>(playerPayload);

    GameMessage gameMessage = gameController.currentStateOfGame(message);

    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER2TURN");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"X", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }
}