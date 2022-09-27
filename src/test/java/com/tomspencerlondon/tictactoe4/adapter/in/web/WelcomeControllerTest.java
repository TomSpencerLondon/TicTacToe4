package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.application.StubIdGenerator;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class WelcomeControllerTest {

  @Test
  void givenNoUserConnectedPlayerOneAssignedToFirstConnectedUser() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER1, (String id, GameState gameState, BoardState boardState, String message) -> {
    });
    WelcomeController controller = new WelcomeController(gameService, new StubIdGenerator());

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model, "windy-dolphin");

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("player"))
        .isEqualTo("1");
  }

  @Test
  void givenOneUserConnectedPlayerTwoAssignedToNextConnectedUser() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER2, (String id, GameState gameState, BoardState boardState, String message) -> {
    });
    WelcomeController controller = new WelcomeController(gameService, new StubIdGenerator());
    controller.game(new ConcurrentModel(), "windy-dolphin");

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model, "windy-dolphin");

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("player"))
        .isEqualTo("2");
  }


  @Test
  void givenGameOverNewGameCreatesNewGame() {
    GameService gameService = new GameService(new TicTacToe(), GameState.GAME_OVER, (String id, GameState gameState, BoardState boardState, String message) -> {
    });
    WelcomeController controller = new WelcomeController(gameService, new StubIdGenerator());

    controller.newGame();

    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.WAITING_FOR_PLAYER1);
  }
}