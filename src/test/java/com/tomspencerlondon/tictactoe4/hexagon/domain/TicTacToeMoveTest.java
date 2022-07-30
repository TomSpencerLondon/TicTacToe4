package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class TicTacToeMoveTest {

  @Test
  void startGameIsEmptyBoard() {
    TicTacToe ticTacToe = new TicTacToe();

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("_________");
  }

  @Test
  void startThenMove_0_IsBoardWithXOnTopRowLeft() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(0);

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("X________");
  }

  @Test
  void startThenMove_1_IsBoardWithXOnTopRowMiddle() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(1);

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("_X_______");
  }

  @Test
  void startThenMove_8_IsBoardWithXOnBottomRowRight() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.move(8);

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("________X");
  }

  @Test
  void twoMovesIsBoardWithAlternatePlayers() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(0);

    ticTacToe.move(1);

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("XO_______");
  }

  @Test
  void threeMovesIsBoardWithTwoPlayerAndOneComputer() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.move(0);
    ticTacToe.move(1);

    ticTacToe.move(7);

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("XO_____X_");
  }

  String asString(BoardState boardState) {
    return Arrays.stream(boardState.state())
        .flatMap(Arrays::stream)
        .collect(Collectors.joining());
  }
}
