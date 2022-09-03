package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public record PlayerPayload(String command, String square, int player) {

  void execute(GameService gameService) {
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
