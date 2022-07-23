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

  String asString() {
    return String.join("", board);
  }

  void play(int move, String piece) {
    board[move] = piece;
  }

  boolean contains(int position, String piece) {
    return board[position].equals(piece);
  }
}
