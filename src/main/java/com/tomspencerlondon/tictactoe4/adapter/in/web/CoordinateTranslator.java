package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public class CoordinateTranslator {
  public static Coordinate fromMove(int move) {
    return new Coordinate(move / 3, move % 3);
  }
}
