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
    TicTacToe ticTacToe = new TicTacToe(new Board("XXX", "_O_", "_O_"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void threeXInMiddleRowOutcomeIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("_O_", "XXX", "_O_"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void oneXIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X__", "___", "___"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoXTopRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("XX_", "___", "__O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoMiddleRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "XX_", "__O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoInMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "X_X", "O_O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoEndOfMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "_XX", "O_O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void threeOnBottomRowIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "_OO", "XXX"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoOnBottomRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "_OO", "XX_"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparatedOnBottomRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("___", "_OO", "X_X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void leftColumnIsWin() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X__", "XOO", "X__"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoInLeftColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X__", "XOO", "___"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparateInLeftColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X__", "_OO", "X__"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void threeInMiddleColumnIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("_X_", "OXO", "_X_"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoInMiddleColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("_X_", "OXO", "___"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparateInMiddleColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("_X_", "O_O", "_X_"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void threeInRightColumnIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "OOX", "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoInRightColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "OOX", "___"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparateInRightColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "OO_", "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void leftToRightDiagonalIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X_O", "OX_", "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X_O", "OX_", "___"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparateInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("X_O", "O__", "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void middleAndBottomRightInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__O", "OX_", "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void rightToLeftDiagonalIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "OX_", "X_O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }

  @Test
  void twoInRightToLeftDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "OX_", "__O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }

  @Test
  void twoSeparateInRightToLeftDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board("__X", "O__", "X_O"));

    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");
  }
}
