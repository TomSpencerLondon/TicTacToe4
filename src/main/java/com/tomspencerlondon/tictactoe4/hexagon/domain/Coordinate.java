package com.tomspencerlondon.tictactoe4.hexagon.domain;

import java.util.List;

public record Coordinate(int x, int y) {

  public static Coordinate fromMove(int move) {
    return List.of(new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(0, 2), new Coordinate(1, 0), new Coordinate(1, 1), new Coordinate(1, 2), new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2))
        .get(move);
  }
}
