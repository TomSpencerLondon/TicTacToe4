package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  void newGameOutcomeIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe();
    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);

  }

  @Test
  void threeXInTopRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XXX",
        "_O_",
        "_O_"
    ));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void threeOInMiddleRowOutcomeIsPlayerOWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OOO",
        "_X_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_O_WINS);
  }

  @Test
  void threeXInMiddleRowOutcomeIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_O_",
        "XXX",
        "_O_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void oneXIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "___",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoXTopRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XX_",
        "___",
        "__O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoMiddleRowIsGameInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "XX_",
        "__O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoInMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "X_X",
        "O_O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoEndOfMiddleRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_XX",
        "O_O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void threeOnBottomRowIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_OO",
        "XXX"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoOnBottomRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_OO",
        "XX_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparatedOnBottomRowIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "___",
        "_OO",
        "X_X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void leftColumnIsWinForX() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "XOO",
        "X__"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoInLeftColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "XOO",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparateInLeftColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "_OO",
        "X__"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void threeInMiddleColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OXO",
        "_X_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoInMiddleColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "OXO",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparateInMiddleColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "_X_",
        "O_O",
        "_X_"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void threeInRightColumnIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OOX",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoInRightColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OOX",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparateInRightColumnIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OO_",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void leftToRightDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X_O",
        "OX_",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X_O",
        "OX_",
        "___"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparateInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X_O",
        "O__",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void middleAndBottomRightInLeftToRightDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__O",
        "OX_",
        "__X"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void rightToLeftDiagonalIsPlayerXWins() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OX_",
        "X_O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.PLAYER_X_WINS);
  }

  @Test
  void twoInRightToLeftDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "OX_",
        "__O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void twoSeparateInRightToLeftDiagonalIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "__X",
        "O__",
        "X_O"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.IN_PROGRESS);
  }

  @Test
  void fullBoardWithoutWinnerIsDraw() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "XOX",
        "OXO",
        "OXO"));

    assertThat(ticTacToe.gameState())
        .isEqualByComparingTo(GameState.DRAW);
  }
}
