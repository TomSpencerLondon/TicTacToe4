package com.tomspencerlondon.tictactoe4;

public class TicTacToe {

  private String board;

  public TicTacToe() {
    board = "_________";
  }

  public String board() {
    return board;
  }

  public void move(int move) {
    board = "X" + board.substring(1);
  }
}
