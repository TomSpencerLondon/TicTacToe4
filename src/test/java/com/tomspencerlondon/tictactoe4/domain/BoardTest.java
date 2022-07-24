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
  }
}