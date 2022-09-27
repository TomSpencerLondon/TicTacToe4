package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public record PlayerPayload(String id, String command, String square, String player) {

  void execute(GameService gameService) {
    if (isPlay()) {
      gameService.play(id, coordinate(), Integer.parseInt(player));
    } else if (command.equals("connect")) {
      gameService.connect(id);
    }
  }

  private Coordinate coordinate() {
    return CoordinateTranslator.fromMove(Integer.parseInt(square()));
  }

  private boolean isPlay() {
    return command().equals("play");
  }
}
