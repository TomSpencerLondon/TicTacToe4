package com.tomspencerlondon.tictactoe4.domain;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

  private final List<Place> places = List.of(new Place(0, 0), new Place(0, 1), new Place(0, 2), new Place(1, 0), new Place(1, 1), new Place(1, 2), new Place(2, 0), new Place(2, 1), new Place(2, 2));
  private String[][] board = new String[3][3];

  public Board() {
    Arrays.fill(board[0], "_");
    Arrays.fill(board[1], "_");
    Arrays.fill(board[2], "_");
  }

  private Board(String[][] board) {
    this.board = board;
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


  String asString() {
    return Arrays.stream(board)
        .flatMap(Arrays::stream)
        .collect(Collectors.joining());
  }

  void play(int move, String piece) {
    Place position = position(move);
    board[position.x()][position.y()] = piece;
  }

  boolean contains(int position, String piece) {
    Place place = position(position);
    return board[place.x()][place.y()].equals(piece);
  }

  private Place position(int position) {
    return places.get(position);
  }
}
