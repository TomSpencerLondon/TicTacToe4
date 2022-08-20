package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class GameControllerTest {

  @Test
  void givenNoUserConnectedFirstGameRequestReturnsWaitingForPlayerTwo() {
    GameController controller = new GameController(new GameService(new TicTacToe()));

    ConcurrentModel model = new ConcurrentModel();
    String view = controller.game(model);

    assertThat(view)
        .isEqualTo("game");
    assertThat(model.getAttribute("gameState"))
        .isEqualTo("Waiting for player 2");
  }
}