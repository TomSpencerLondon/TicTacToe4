package com.tomspencerlondon.tictactoe4.hexagon.domain;

import java.util.Arrays;

public class BoardState {
  private final String[][] state;

  static BoardState copyOf(String[][] board) {
    String[][] copy = Arrays.stream(board)
        .map(String[]::clone)
        .toArray(String[][]::new);
    return new BoardState(copy);
  }

  private BoardState(String[][] board) {
    state = board;
  }

  public String[][] state() {
    return state;
  }
}
