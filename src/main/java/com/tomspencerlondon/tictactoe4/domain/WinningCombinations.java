package com.tomspencerlondon.tictactoe4.domain;

import java.util.List;
import java.util.stream.Stream;

public record WinningCombinations(int first, int second, int third) {

  private static final List<WinningCombinations> WINNING_COMBINATIONS = List.of(new WinningCombinations(0, 1, 2), new WinningCombinations(3, 4, 5), new WinningCombinations(6, 7, 8), new WinningCombinations(0, 3, 6), new WinningCombinations(1, 4, 7), new WinningCombinations(2, 5, 8), new WinningCombinations(0, 4, 8), new WinningCombinations(2, 4, 6));

  static Stream<WinningCombinations> winningCombinations() {
    return WINNING_COMBINATIONS.stream();
  }

  static boolean hasWon(String piece, String[] board) {
    return winningCombinations().anyMatch(winningCombination -> winningCombination.isWin(piece, board));
  }

  boolean isWin(String piece, String[] board) {
    return board[first()].equals(piece)
        && board[second()].equals(piece)
        && board[third()].equals(piece);
  }
}