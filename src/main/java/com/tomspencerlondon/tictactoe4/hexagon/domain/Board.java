package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Board {

  private String[][] board = new String[3][3];

  public Board() {
    Arrays.fill(board[0], "_");
    Arrays.fill(board[1], "_");
    Arrays.fill(board[2], "_");
  }

  public Board(String topRow, String middleRow, String bottomRow) {
    String fullBoard = topRow + middleRow + bottomRow;
    Iterator<String> iterator = asList(fullBoard.split("")).iterator();
    String[][] board = new String[3][3];
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        board[row][column] = iterator.next();
      }
    }

    this.board = board;
  }

  void play(Coordinate coordinate) {
    if (!isEmpty(coordinate)) {
      throw new SquareAlreadyTakenException();
    }

    board[coordinate.x()][coordinate.y()] = currentPlayerPiece();
  }

  private boolean isEmpty(Coordinate position) {
    return Objects.equals(board[position.x()][position.y()], "_");
  }

  boolean contains(Coordinate coordinate, String piece) {
    return board[coordinate.x()][coordinate.y()].equals(piece);
  }

  public BoardState boardState() {
    return BoardState.copyOf(board);
  }

  boolean isFull() {
    for (String[] row : boardState().state()) {
      for (String square : row) {
        if (square.equals("_")) {
          return false;
        }
      }
    }
    return true;
  }

  public String currentPlayerPiece() {
    long x = getCount("X");
    long o = getCount("O");
    if (x == o || x < o) {
      return "X";
    } else {
      return "O";
    }
  }

  private long getCount(String player) {
    return Arrays.stream(board).flatMap(Arrays::stream).filter(s -> s.equals(player)).count();
  }
}
