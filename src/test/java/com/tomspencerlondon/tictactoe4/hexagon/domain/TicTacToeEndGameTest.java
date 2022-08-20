package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  void givenNewGameGameOutcomeThrowsException() {
    TicTacToe ticTacToe = new TicTacToe();
    assertThatThrownBy(ticTacToe::outcome)
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void givenOneMoveRemainingGameOutcomeThrowsException() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XO_",
        "XOX",
        "OXO"));

    assertThatThrownBy(ticTacToe::outcome)
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void threeXInTopRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XXX",
        "_O_",
        "_O_"
    ));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void threeXInMiddleRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_O_",
        "XXX",
        "_O_"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void threeOnBottomRowIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_OO",
        "XXX"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void leftColumnIsWinForX() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "XOO",
        "X__"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void threeInMiddleColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OXO",
        "_X_"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void threeInRightColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OOX",
        "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void leftToRightDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X_O",
        "OX_",
        "__X"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void rightToLeftDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OX_",
        "X_O"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void fullBoardWithoutWinnerIsDraw() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XOX",
        "OXO",
        "OXO"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.DRAW);
  }

  @Test
  void threeOInMiddleRowOutcomeIsPlayerOWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OOO",
        "_X_"));

    assertThat(ticTacToe.outcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_O_WINS);
  }
}
