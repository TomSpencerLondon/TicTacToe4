package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class GameControllerTest {

  @Test
  void givenNoUserConnectedWhenGameRequestReturnsWaitingForPlayerTwo() {
    GameService gameService = new GameService(new TicTacToe());
    GameController controller = new GameController(gameService);

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model);

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("message"))
        .isEqualTo("Waiting for player 2");
    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.WAITING_FOR_PLAYER2);
  }

  @Test
  void givenOneUserConnectedWhenGameRequestReturnsConnectingToGame() {
    GameService gameService = new GameService(new TicTacToe());
    GameController controller = new GameController(gameService);
    controller.game(new ConcurrentModel());

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model);

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("message"))
        .isEqualTo("Connecting to game");
    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.PLAYER1TURN);
  }
}