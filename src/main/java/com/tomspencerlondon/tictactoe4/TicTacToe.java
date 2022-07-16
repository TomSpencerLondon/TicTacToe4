package com.tomspencerlondon.tictactoe4;

import java.util.Arrays;

public class TicTacToe {

  private final String[] board;
  private boolean isPlayerMove;

  public TicTacToe() {
    board = new String[9];
    Arrays.fill(board, "_");
    isPlayerMove = true;
  }

  public String board() {
    return String.join("", board);
  }

  public void move(int move) {
    board[move] = isPlayerMove ? "X" : "";
  }
}
