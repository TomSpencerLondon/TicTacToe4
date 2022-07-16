package com.tomspencerlondon.tictactoe4;

import java.util.Arrays;

public class TicTacToe {

  private final String[] board;

  public TicTacToe() {
    board = new String[9];
    Arrays.fill(board, "_");
  }

  public String board() {
    return String.join("", board);
  }

  public void move(int move) {
    board[move] = "X";
  }
}
