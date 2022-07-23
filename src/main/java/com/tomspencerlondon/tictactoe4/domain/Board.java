package com.tomspencerlondon.tictactoe4.domain;

public class Board {
  private String[] board = new String[9];

  public Board() {
  }

  public Board(String[] board) {
    this.board = board;
  }

  @Deprecated
  public String[] getboard() {
    return board;
  }
}
