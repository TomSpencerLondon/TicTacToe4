package com.tomspencerlondon.tictactoe4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {

  @Test
  void startGameIsEmptyBoard() {
    TicTacToe ticTacToe = new TicTacToe();

    assertThat(ticTacToe.board())
        .isEqualTo("_________");
  }
}
