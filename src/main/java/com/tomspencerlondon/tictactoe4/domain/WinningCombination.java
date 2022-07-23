package com.tomspencerlondon.tictactoe4.domain;

public record WinningCombination(int first, int second, int third) {

  boolean isWin(String piece, Board board) {
    return board.getboard()[first()].equals(piece)
        && board.getboard()[second()].equals(piece)
        && board.getboard()[third()].equals(piece);
  }
}