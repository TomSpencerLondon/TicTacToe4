package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public record PlayerPayload(String command, String square, int player) {

  void execute(GameService gameService) {
    if (player() == 2 && gameService.gameState() == GameState.PLAYER1TURN) {
      return;
    } else if (player() == 1 && gameService.gameState() == GameState.PLAYER2TURN) {
      return;
    }
    if (isPlay()) {
      gameService.play(coordinate());
    }
  }

  private Coordinate coordinate() {
    return CoordinateTranslator.fromMove(Integer.parseInt(square()));
  }

  private boolean isPlay() {
    return command().equals("play");
  }
}
