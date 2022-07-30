package com.tomspencerlondon.tictactoe4.hexagon.domain;

import java.util.List;

public class WinChecker {

  private static final List<WinningCombination> WINNING_COMBINATIONS = List.of(
      new WinningCombination(0, 1, 2),
      new WinningCombination(3, 4, 5),
      new WinningCombination(6, 7, 8),
      new WinningCombination(0, 3, 6),
      new WinningCombination(1, 4, 7),
      new WinningCombination(2, 5, 8),
      new WinningCombination(0, 4, 8),
      new WinningCombination(2, 4, 6));

  boolean hasWon(String piece, Board board) {
    return WINNING_COMBINATIONS.stream()
        .anyMatch(winningCombination -> winningCombination.isWin(piece, board));
  }
}
