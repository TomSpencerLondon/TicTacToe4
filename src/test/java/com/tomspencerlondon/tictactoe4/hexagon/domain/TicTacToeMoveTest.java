package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tomspencerlondon.tictactoe4.adapter.in.web.CoordinateTranslator;
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

    ticTacToe.play(CoordinateTranslator.fromMove(0));

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("X________");
  }

  @Test
  void startThenMove_1_IsBoardWithXOnTopRowMiddle() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.play(CoordinateTranslator.fromMove(1));

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("_X_______");
  }

  @Test
  void startThenMove_8_IsBoardWithXOnBottomRowRight() {
    TicTacToe ticTacToe = new TicTacToe();

    ticTacToe.play(CoordinateTranslator.fromMove(8));

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("________X");
  }

  @Test
  void twoMovesIsBoardWithAlternatePlayers() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.play(CoordinateTranslator.fromMove(0));

    ticTacToe.play(CoordinateTranslator.fromMove(1));

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("XO_______");
  }

  @Test
  void threeMovesIsBoardWithTwoXAndOneO() {
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.play(CoordinateTranslator.fromMove(0));
    ticTacToe.play(CoordinateTranslator.fromMove(1));

    ticTacToe.play(CoordinateTranslator.fromMove(7));

    assertThat(asString(ticTacToe.boardState()))
        .isEqualTo("XO_____X_");
  }

  @Test
  void givenBoardWithNextMoveDrawStateAfterMoveIsDraw() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "O_X"
    ));

    ticTacToe.play(CoordinateTranslator.fromMove(7));

    assertThat(ticTacToe.ticTacToeState())
        .isEqualTo(TicTacToeState.DRAW);
  }

  @Test
  void givenBoardWithNextMoveDrawStateAfterMoveOnTakenSquareIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "X__",
        "___",
        "___"
    ));

    assertThatThrownBy(() -> ticTacToe.play(CoordinateTranslator.fromMove(0)))
        .isInstanceOf(SquareAlreadyTakenException.class);
  }

  String asString(BoardState boardState) {
    return Arrays.stream(boardState.state())
        .flatMap(Arrays::stream)
        .collect(Collectors.joining());
  }
}
