package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoordinateTest {

  @ParameterizedTest
  @MethodSource("moveToCoordinate")
  void translateMoveToCoordinate(Integer move, Coordinate coordinate) {
    assertThat(coordinate(move))
        .isEqualTo(coordinate);

  }

  private static Stream<Arguments> moveToCoordinate() {
    return Stream.of(
      Arguments.of(0, new Coordinate(0, 0)),
      Arguments.of(1, new Coordinate(0, 1)),
      Arguments.of(2, new Coordinate(0, 2)),
      Arguments.of(3, new Coordinate(1, 0)),
      Arguments.of(4, new Coordinate(1, 1)),
      Arguments.of(5, new Coordinate(1, 2)),
      Arguments.of(6, new Coordinate(2, 0)),
      Arguments.of(7, new Coordinate(2, 1)),
      Arguments.of(8, new Coordinate(2, 2))
    );
  }

  private static Coordinate coordinate(int move) {
    return new Coordinate(row(move), column(move));
  }

  private static int row(int move) {
    return move / 3;
  }

  private static int column(int move) {
    return move % 3;
  }

  @Test
  void translateMove2ToRow0_Column2() {
    int move = 2;
    int row = row(move);
    int column = column(move);

    assertThat(row)
        .isEqualTo(0);
    assertThat(column)
        .isEqualTo(2);
  }

  @Test
  void translateMove3ToRow1_Column0() {
    int move = 3;

    assertThat(row(move))
        .isEqualTo(1);

    assertThat(column(move))
        .isEqualTo(0);
  }

  @Test
  void translateMove4ToRow1_Column1() {
    int move = 4;

    assertThat(row(move))
        .isEqualTo(1);

    assertThat(column(move))
        .isEqualTo(1);
  }

  @Test
  void translatesMove5ToRow1_Column2() {
    int move = 5;

    assertThat(row(move))
        .isEqualTo(1);

    assertThat(column(move))
        .isEqualTo(2);
  }

  @Test
  void translateMove8ToRow2_Column2() {
    int move = 8;

    assertThat(row(move))
        .isEqualTo(2);

    assertThat(column(move))
        .isEqualTo(2);
  }
}