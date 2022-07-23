package com.tomspencerlondon.tictactoe4.domain;

public record WinningCombination(int first, int second, int third) {

  boolean isWin(String piece, Board board) {
    return board.contains(first(), piece)
        && board.contains(second(), piece)
        && board.contains(third(), piece);
  }
}
