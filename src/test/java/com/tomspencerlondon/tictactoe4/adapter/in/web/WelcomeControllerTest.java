package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class WelcomeControllerTest {

  @Test
  void givenNoUserConnectedPlayerOneAssignedToFirstConnectedUser() {
    GameService gameService = new GameService(new TicTacToe(), (GameState gameState, BoardState boardState) -> {
    });
    WelcomeController controller = new WelcomeController(gameService);

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model);

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("message"))
        .isEqualTo("Waiting for player 2");
    assertThat(model.getAttribute("player"))
        .isEqualTo(GameState.PLAYER1TURN.toString());
    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.WAITING_FOR_PLAYER2);
  }

  @Test
  void givenOneUserConnectedPlayerTwoAssignedToNextConnectedUser() {
    GameService gameService = new GameService(new TicTacToe(), (GameState gameState, BoardState boardState) -> {
    });
    WelcomeController controller = new WelcomeController(gameService);
    controller.game(new ConcurrentModel());

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model);

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("message"))
        .isEqualTo("Connecting to game");
    assertThat(model.getAttribute("player"))
        .isEqualTo(GameState.PLAYER2TURN.toString());
    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.PLAYER1TURN);
  }
}