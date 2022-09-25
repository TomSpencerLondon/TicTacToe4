package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public record PlayerPayload(String command, String square, String playerTurn) {

  void execute(GameService gameService) {
    if (isPlay()) {
      gameService.play(coordinate(), Integer.parseInt(playerTurn));
    } else if (command.equals("connect")) {
      gameService.connect();
    }
  }

  private Coordinate coordinate() {
    return CoordinateTranslator.fromMove(Integer.parseInt(square()));
  }

  private boolean isPlay() {
    return command().equals("play");
  }
}
