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
    return topRow() || middleRow() || bottomRow() ||
        leftColumn() || middleColumn() || rightColumn() ||
        leftToRightDiagonal();
  }

  private boolean leftToRightDiagonal() {
    return board[0].equals("X") && board[4].equals("X") && board[8].equals("X");
  }

  private boolean rightColumn() {
    return board[2].equals("X") && board[5].equals("X") && board[8].equals("X");
  }

  private boolean middleColumn() {
    return board[1].equals("X") && board[4].equals("X") && board[7].equals("X");
  }

  private boolean leftColumn() {
    return board[0].equals("X") && board[3].equals("X") && board[6].equals("X");
  }

  private boolean bottomRow() {
    return board[6].equals("X") && board[7].equals("X") && board[8].equals("X");
  }

  private boolean middleRow() {
    return board[3].equals("X") && board[4].equals("X") && board[5].equals("X");
  }

  private boolean topRow() {
    return board[0].equals("X") && board[1].equals("X") && board[2].equals("X");
  }
}
