package com.tomspencerlondon.tictactoe4.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeMoveTest {

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
  void startThenMove_1_IsBoardWithXOnTopRowMiddle() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(1);

    assertThat(ticTacToe.board())
        .isEqualTo("_X_______");
  }

  @Test
  void startThenMove_8_IsBoardWithXOnBottomRowRight() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(8);

    assertThat(ticTacToe.board())
        .isEqualTo("________X");
  }

  @Test
  void twoMovesIsBoardWithAlternatePlayers() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(0);

    ticTacToe.move(1);

    assertThat(ticTacToe.board())
        .isEqualTo("XO_______");
  }

  @Test
  void threeMovesIsBoardWithTwoPlayerAndOneComputer() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(0);
    ticTacToe.move(1);

    ticTacToe.move(7);

    assertThat(ticTacToe.board())
        .isEqualTo("XO_____X_");
  }
}
