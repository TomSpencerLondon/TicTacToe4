package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardFactory;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class GameControllerTest {

  @Test
  void returnsBoardState() {
    GameController controller = new GameController(new GameService(new TicTacToe()));
    Model model = new ConcurrentModel();

    controller.game(model);

    String[][] expected = BoardFactory.empty();
    assertThat(model.getAttribute("board"))
        .isEqualTo(expected);
  }

}