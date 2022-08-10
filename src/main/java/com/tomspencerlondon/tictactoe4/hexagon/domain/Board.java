package com.tomspencerlondon.tictactoe4.hexagon.domain;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Board {

  private final List<Coordinate> coordinates = List.of(new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(0, 2), new Coordinate(1, 0), new Coordinate(1, 1), new Coordinate(1, 2), new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2));
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
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = iterator.next();
      }
    }

    this.board = board;
  }

  void play(int move, String piece) {
    Coordinate coordinate = transformToCoordinate(move);
    if (!isEmpty(coordinate)) {
      throw new SquareAlreadyTakenException();
    }
    if (isEmpty(coordinate)) {
      board[coordinate.x()][coordinate.y()] = piece;
    }
  }

  private boolean isEmpty(Coordinate position) {
    return Objects.equals(board[position.x()][position.y()], "_");
  }

  boolean contains(int position, String piece) {
    Coordinate coordinate = transformToCoordinate(position);
    return board[coordinate.x()][coordinate.y()].equals(piece);
  }

  private Coordinate transformToCoordinate(int move) {
    return coordinates.get(move);
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

  public String playerTurn() {
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
