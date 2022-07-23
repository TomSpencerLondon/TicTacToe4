package com.tomspencerlondon.tictactoe4.domain;

import java.util.Arrays;

public class Board {
  private String[] board = new String[9];

  public Board() {
    Arrays.fill(board, "_");
  }

  public Board(String[] board) {
    this.board = board;
  }

  @Deprecated
  public String[] getboard() {
    return board;
  }

  String asString() {
    return String.join("", getboard());
  }

  void play(int move, String piece) {
    getboard()[move] = piece;
  }

  boolean contains(int position, String piece) {
    return getboard()[position].equals(piece);
  }
}
