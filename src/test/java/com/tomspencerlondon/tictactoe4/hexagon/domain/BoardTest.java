package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    board.play(0);

    assertThat(asString(board))
        .isEqualTo("X________");
    assertThat(board.contains(0, "X"))
        .isTrue();
  }

  @Test
  void givenTwoPlaysBoardContainsPositions() {
    Board board = new Board();

    board.play(0);
    board.play(1);

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

    board.play(0);
    board.play(1);
    board.play(2);
    board.play(3);
    board.play(4);
    board.play(5);
    board.play(6);
    board.play(7);
    board.play(8);

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
    board.play(1);

    assertThat(result)
        .isEqualTo(expected);
  }

  @Test
  void boardWithNoPlayerTurnIsX() {
    Board board = new Board("___", "___", "___");

    assertThat(board.currentPlayerPiece())
        .isEqualTo("X");
  }

  @Test
  void givenBoardWithSingleXThenPlayerTurnIsO() {
    Board board = new Board("X__", "___", "___");

    assertThat(board.currentPlayerPiece())
        .isEqualTo("O");
  }

  @Test
  void boardWith2XAnd2OPlayerTurnIsX() {
    Board board = new Board("XX_", "OO_", "___");

    assertThat(board.currentPlayerPiece())
        .isEqualTo("X");
  }

  @Test
  void boardWith3XAnd2OPlayerTurnIsO() {
    Board board = new Board("XX_", "OO_", "X__");

    assertThat(board.currentPlayerPiece())
        .isEqualTo("O");
  }

  @Test
  void moveOnTakenSquareThrowsException() {
    Board board = new Board("X__", "___", "___");

    assertThatThrownBy(() -> board.play(0))
        .isInstanceOf(SquareAlreadyTakenException.class);
  }

  @Test
  void samePlayerTurnAfterIllegalMove() {
    Board board = new Board("X__", "___", "___");

    try {
      board.play(0);
    } catch (SquareAlreadyTakenException ignored) {
    }

    assertThat(board.currentPlayerPiece())
        .isEqualTo("O");
  }

  static String asString(Board board) {
    return Arrays.stream(board.boardState().state())
        .flatMap(Arrays::stream)
        .collect(Collectors.joining());
  }
}
