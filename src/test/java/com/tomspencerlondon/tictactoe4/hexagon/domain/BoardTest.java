package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void givenNoPlayBoardIsEmpty() {
    Board board = new Board();

    assertThat(asString(board))
        .isEqualTo("_________");
  }

  @Test
  void givenPlayZeroBoardContainsPosition() {
    Board board = new Board();

    board.play(0, "X");

    assertThat(asString(board))
        .isEqualTo("X________");
    assertThat(board.contains(0, "X"))
        .isTrue();
  }

  @Test
  void givenTwoPlaysBoardContainsPositions() {
    Board board = new Board();

    board.play(0, "X");
    board.play(1, "O");

    assertThat(asString(board))
        .isEqualTo("XO_______");
    assertThat(board.contains(0, "X"))
        .isTrue();
    assertThat(board.contains(1, "O"))
        .isTrue();
  }

  @Test
  void givenFullBoardBoardContainsPositions() {
    Board board = new Board();

    board.play(0, "X");
    board.play(1, "O");
    board.play(2, "X");
    board.play(3, "O");
    board.play(4, "X");
    board.play(5, "O");
    board.play(6, "X");
    board.play(7, "O");
    board.play(8, "X");

    assertThat(asString(board))
        .isEqualTo("XOXOXOXOX");
    assertThat(board.contains(0, "X"))
        .isTrue();
    assertThat(board.contains(1, "O"))
        .isTrue();
    assertThat(board.contains(2, "X"))
        .isTrue();
    assertThat(board.contains(3, "O"))
        .isTrue();
    assertThat(board.contains(4, "X"))
        .isTrue();
    assertThat(board.contains(5, "O"))
        .isTrue();
    assertThat(board.contains(6, "X"))
        .isTrue();
    assertThat(board.contains(7, "O"))
        .isTrue();
    assertThat(board.contains(8, "X"))
        .isTrue();
  }

  @Test
  void boardQueryReturnsCopyOfBoard() {
    Board board = new Board();
    String[][] expected = BoardFactory.empty();

    String[][] result = board.boardState().state();
    board.play(1, "X");

    assertThat(result)
        .isEqualTo(expected);
  }

  static String asString(Board board) {
    return Arrays.stream(board.boardState().state())
        .flatMap(Arrays::stream)
        .collect(Collectors.joining());
  }

  @Test
  void boardWith2XAnd2OPlayerTurnIsX() {
    Board board = new Board("XX_", "OO_", "___");

    assertThat(board.playerTurn())
        .isEqualTo("X");
  }

  @Test
  void boardWith3XAnd2OPlayerTurnIsO() {
    Board board = new Board("XX_", "OO_", "X__");

    assertThat(board.playerTurn())
        .isEqualTo("O");
  }

  @Test
  void givenBoardWithNextMoveDrawStateAfterMoveOnTakenSquareIsInProgress() {
    Board board = new Board("OOX", "XXO", "O_X");

    board.play(6, "X");

    assertThat(board.boardState().state()[0])
        .isEqualTo(new String[]{"O", "O", "X"});
    assertThat(board.boardState().state()[1])
        .isEqualTo(new String[]{"X", "X", "O"});
    assertThat(board.boardState().state()[2])
        .isEqualTo(new String[]{"O", "_", "X"});
  }
}
