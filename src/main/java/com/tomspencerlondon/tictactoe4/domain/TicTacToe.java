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
    return playerWinsWith(2, 4, 6);
  }

  private boolean leftToRightDiagonal() {
    return playerWinsWith(0, 4, 8);
  }

  private boolean column(int first) {
    return playerWinsWith(first, first + 3, first + 6);
  }

  private boolean row(int first) {
    return playerWinsWith(first, first + 1, first + 2);
  }

  private boolean playerWinsWith(int x, int x1, int x2) {
    return board[x].equals("X") && board[x1].equals("X") && board[x2].equals("X");
  }

}
