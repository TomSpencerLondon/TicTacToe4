package com.tomspencerlondon.tictactoe4.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void givenNoPlayBoardIsEmpty() {
    Board board = new Board();

    assertThat(board.asString())
        .isEqualTo("_________");
  }

  @Test
  void givenPlayZeroBoardContainsPosition() {
    Board board = new Board();

    board.play(0, "X");

    assertThat(board.asString())
        .isEqualTo("X________");
    assertThat(board.contains(0, "X"))
        .isTrue();
  }

  @Test
  void givenTwoPlaysBoardContainsPositions() {
    Board board = new Board();

    board.play(0, "X");
    board.play(1, "O");

    assertThat(board.asString())
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

    assertThat(board.asString())
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


}