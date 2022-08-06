package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.domain.GameState;

public class GameStateTranslator {

  static String transform(GameState state) {
    if (state == GameState.PLAYER_X_WINS) {
      return "Player X wins!";
    } else if (state == GameState.PLAYER_O_WINS) {
      return "Player O wins!";
    } else if (state == GameState.DRAW) {
      return "Draw!";
    }

    return "In Progress";
  }
}
