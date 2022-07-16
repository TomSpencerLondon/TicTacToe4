package com.tomspencerlondon.tictactoe4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

  @Test
  void startGameIsEmptyBoard() {
    TicTacToe ticTacToe = new TicTacToe();

    assertThat(ticTacToe.board())
        .isEqualTo("_________");
  }

  @Test
  void startThenMove_0_IsBoardWithXOnTopRowLeft() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(0);

    assertThat(ticTacToe.board())
        .isEqualTo("X________");
  }

  @Test
  @Disabled
  void startThenMove_1_IsBoardWithXOnTopRowMiddle() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(1);

    assertThat(ticTacToe.board())
        .isEqualTo("_X_______");
  }
}
