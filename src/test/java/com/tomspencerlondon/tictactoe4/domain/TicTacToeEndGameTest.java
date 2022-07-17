package com.tomspencerlondon.tictactoe4.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  void newGameOutcomeIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe();
    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");

  }

  @Test
  void threeXInTopRowOutcomeIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(
        "XXX",
        "_O_",
        "_O_");

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void threeXInMiddleRowOutcomeIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(
        "_O_",
        "XXX",
        "_O_");

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void oneXIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(
        "X__",
        "___",
        "___");

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoXTopRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(
        "XX_",
        "___",
        "__O");

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoMiddleRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(
        "___",
        "XX_",
        "__O");

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoInMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(
        "___",
        "X_X",
        "O_O");

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoEndOfMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(
        "___",
        "_XX",
        "O_O");

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void threeOnBottomRowIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(
        "___",
        "_OO",
        "XXX");

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }
}
