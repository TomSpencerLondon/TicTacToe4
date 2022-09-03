package com.tomspencerlondon.tictactoe4.hexagon.domain;

import com.tomspencerlondon.tictactoe4.adapter.in.websocket.CoordinateTranslator;

public record WinningCombination(int first, int second, int third) {

  boolean isWin(String piece, Board board) {
    return board.contains(CoordinateTranslator.fromMove(first()), piece)
        && board.contains(CoordinateTranslator.fromMove(second()), piece)
        && board.contains(CoordinateTranslator.fromMove(third()), piece);
  }
}
