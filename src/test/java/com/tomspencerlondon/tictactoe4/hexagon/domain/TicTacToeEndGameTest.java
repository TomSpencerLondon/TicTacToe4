package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  void newGameOutcomeIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe();
    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.IN_PROGRESS);
  }

  @Test
  void oneXIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "___",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.IN_PROGRESS);
  }

  @Test
  void twoXTopRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XX_",
        "___",
        "__O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.IN_PROGRESS);
  }

  @Test
  void threeXInTopRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XXX",
        "_O_",
        "_O_"
    ));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void threeXInMiddleRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_O_",
        "XXX",
        "_O_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void threeOnBottomRowIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_OO",
        "XXX"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void leftColumnIsWinForX() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "XOO",
        "X__"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void threeInMiddleColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OXO",
        "_X_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void threeInRightColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OOX",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void leftToRightDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X_O",
        "OX_",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void rightToLeftDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OX_",
        "X_O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_X_WINS);
  }

  @Test
  void fullBoardWithoutWinnerIsDraw() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XOX",
        "OXO",
        "OXO"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.DRAW);
  }

  @Test
  void threeOInMiddleRowOutcomeIsPlayerOWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OOO",
        "_X_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(TicTacToeState.PLAYER_O_WINS);
  }
}
