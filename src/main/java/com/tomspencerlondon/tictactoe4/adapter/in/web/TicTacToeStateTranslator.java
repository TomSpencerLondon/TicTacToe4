package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToeState;

public class TicTacToeStateTranslator {

  static String transform(TicTacToeState state) {
    if (state == TicTacToeState.PLAYER_X_WINS) {
      return "Player X wins!";
    } else if (state == TicTacToeState.PLAYER_O_WINS) {
      return "Player O wins!";
    } else if (state == TicTacToeState.DRAW) {
      return "Draw!";
    }

    return "In Progress";
  }
}
