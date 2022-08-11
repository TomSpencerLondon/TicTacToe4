package com.tomspencerlondon.tictactoe4.hexagon.domain;

public record WinningCombination(int first, int second, int third) {

  boolean isWin(String piece, Board board) {
    return board.contains(Coordinate.fromMove(first()), piece)
        && board.contains(Coordinate.fromMove(second()), piece)
        && board.contains(Coordinate.fromMove(third()), piece);
  }
}
