package com.tomspencerlondon.tictactoe4.domain;

import java.util.Arrays;

public class TicTacToe {

  private final Board board;
  private boolean isPlayerMove;
  private final WinChecker winChecker = new WinChecker();

  public TicTacToe() {
    board = new Board();
    Arrays.fill(board.getboard(), "_");
    isPlayerMove = true;
  }

  // Used only for tests
  @Deprecated
  public TicTacToe(String topRow, String middleRow, String bottomRow) {
    String fullBoard = topRow + middleRow + bottomRow;
    board = new Board(fullBoard.split(""));
  }


  public String board() {
    return String.join("", board.getboard());
  }

  public void move(int move) {
    board.getboard()[move] = isPlayerMove ? "X" : "O";
    isPlayerMove = !isPlayerMove;
  }

  public String outcome() {
    if (playerWins("X")) {
      return "Player wins!";
    }

    return "In Progress";
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board.getboard());
  }

}
