package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.domain.GameOutcome;

public class TicTacToeStateTranslator {

  static String transform(GameOutcome state) {
    if (state == GameOutcome.PLAYER_X_WINS) {
      return "Player X wins!";
    } else if (state == GameOutcome.PLAYER_O_WINS) {
      return "Player O wins!";
    } else if (state == GameOutcome.DRAW) {
      return "Draw!";
    }

    return "In Progress";
  }
}
