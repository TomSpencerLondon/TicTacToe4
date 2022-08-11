package com.tomspencerlondon.tictactoe4.hexagon.domain;

public record Coordinate(int x, int y) {

  public static Coordinate fromMove(int move) {
    return new Coordinate(move / 3, move % 3);
  }
}
