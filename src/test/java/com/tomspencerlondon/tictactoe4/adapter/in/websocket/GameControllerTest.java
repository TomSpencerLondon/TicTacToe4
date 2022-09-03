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

    GameMessage gameMessage = gameController.currentStateOfGame(connectMessage(1));

    assertThat(gameMessage.getGameState()).isEqualTo("WAITING_FOR_PLAYER2");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  @Test
  void givenTwoConnectionsThenRequestForCurrentStateOfGameReturnsPlayerOneTurnWithEmptyBoard() {
    GameController gameController = controllerWithTwoConnections();

    GameMessage gameMessage = gameController.currentStateOfGame(connectMessage(2));

    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  @Test
  void givenPlayerOneTurnThenRequestReturnsPlayerTwoTurnAndUpdatedBoard() {
    GameController gameController = controllerWithTwoConnections();

    GameMessage gameMessage = gameController.currentStateOfGame(playMessage("0", 1));

    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER2TURN");
    assertThat(gameMessage.getBoard())
        .isEqualTo(new String[][]{{"X", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
  }

  private static GenericMessage<PlayerPayload> playMessage(String square, int player) {
    return createMessage("play", square, player);
  }

  private static GenericMessage<PlayerPayload> connectMessage(int player) {
    return createMessage("connect", "", player);
  }

  private static GenericMessage<PlayerPayload> createMessage(String connect, String square, int player) {
    PlayerPayload playerPayload = new PlayerPayload(connect, square, player);
    GenericMessage<PlayerPayload> message = new GenericMessage<>(playerPayload);
    return message;
  }

  private static GameController controllerWithTwoConnections() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    GameController gameController = new GameController(gameService);
    return gameController;
  }
}