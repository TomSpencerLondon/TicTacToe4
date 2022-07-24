package com.tomspencerlondon.tictactoe4.domain;

import static java.util.Arrays.asList;

import java.util.Iterator;

public class TicTacToe {

  private final Board board;
  private boolean isPlayerMove;
  private final WinChecker winChecker = new WinChecker();

  public TicTacToe() {
    board = new Board();
    isPlayerMove = true;
  }

  // Used only for tests
  @Deprecated
  public TicTacToe(String topRow, String middleRow, String bottomRow) {
    String fullBoard = topRow + middleRow + bottomRow;
    Iterator<String> iterator = asList(fullBoard.split("")).iterator();
    String[][] board = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = iterator.next();
      }
    }
    this.board = new Board(board);
  }


  public String board() {
    return board.asString();
  }

  public void move(int position) {
    board.play(position, isPlayerMove ? "X" : "O");
    isPlayerMove = !isPlayerMove;
  }

  public String outcome() {
    if (playerWins("X")) {
      return "Player wins!";
    }

    return "In Progress";
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board);
  }

}
