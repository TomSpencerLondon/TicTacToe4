package com.tomspencerlondon.tictactoe4.hexagon.domain;

import java.util.Arrays;

public class BoardState {
  private final String[][] state;

  public static BoardState copyOf(String[][] board) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BoardState that = (BoardState) o;

    return Arrays.deepEquals(state, that.state);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(state);
  }
}
