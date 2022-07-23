package com.tomspencerlondon.tictactoe4.domain;

public record WinningCombinations(int first, int second, int third) {

  boolean isWin(String piece, String[] board) {
    return board[first()].equals(piece)
        && board[second()].equals(piece)
        && board[third()].equals(piece);
  }
}