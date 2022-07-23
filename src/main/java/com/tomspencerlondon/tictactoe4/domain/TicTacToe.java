package com.tomspencerlondon.tictactoe4.domain;

import java.util.Arrays;
import java.util.List;

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
    List<WinningCombinations> winningCombinations = List.of(new WinningCombinations(0, 1, 2), new WinningCombinations(3, 4, 5), new WinningCombinations(6, 7, 8), new WinningCombinations(0, 3, 6), new WinningCombinations(1, 4, 7), new WinningCombinations(2, 5, 8), new WinningCombinations(0, 4, 8), new WinningCombinations(2, 4, 6));
    for (WinningCombinations winningCombination : winningCombinations) {
      if (playerWinsWith("X", winningCombination)) {
        return true;
      }
    }
    return false;
  }

  private boolean playerWinsWith(String piece, WinningCombinations winningCombinations) {
    return board[winningCombinations.first()].equals(piece) && board[winningCombinations.second()].equals(piece) && board[winningCombinations.third()].equals(piece);
  }

}
