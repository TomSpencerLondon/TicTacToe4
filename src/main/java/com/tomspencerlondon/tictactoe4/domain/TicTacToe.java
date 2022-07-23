package com.tomspencerlondon.tictactoe4.domain;

import java.util.Arrays;

public class TicTacToe {

  private String[] board;
  private boolean isPlayerMove;

  public TicTacToe() {
    board = new String[9];
    Arrays.fill(board, "_");
    isPlayerMove = true;
  }

  // Used only for tests
  @Deprecated
  public TicTacToe(String topRow, String middleRow, String bottomRow) {
    String fullBoard = topRow + middleRow + bottomRow;
    board = fullBoard.split("");
  }


  public String board() {
    return String.join("", board);
  }

  public void move(int move) {
    board[move] = isPlayerMove ? "X" : "O";
    isPlayerMove = !isPlayerMove;
  }

  public String outcome() {
    if (playerWins()) {
      return "Player wins!";
    }

    return "In Progress";
  }

  private boolean playerWins() {
    return isRowWin() || isColumnWin() || leftToRightDiagonal() || rightToLeftDiagonal();
  }

  private boolean isRowWin() {
    return row(0) || row(3) || row(6);
  }

  private boolean isColumnWin() {
    return column(0) || column(1) || column(2);
  }

  private boolean rightToLeftDiagonal() {
    return board[2].equals("X") && board[4].equals("X") && board[6].equals("X");
  }

  private boolean leftToRightDiagonal() {
    return board[0].equals("X") && board[4].equals("X") && board[8].equals("X");
  }

  private boolean column(int first) {
    return board[first].equals("X") && board[first + 3].equals("X") && board[first + 6].equals("X");
  }

  private boolean row(int first) {
    return board[first].equals("X") && board[first + 1].equals("X") && board[first + 2].equals("X");
  }

}
