package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;

public record PlayerPayload(String command, String square, int player) {

  void execute(GameService gameService) {
    if (isPlay() && isValidMove(gameService)) {
      gameService.play(coordinate());
    }
  }

  private boolean isValidMove(GameService gameService) {
    return isCorrectPlayer(gameService) &&
        gameService.gameState() != GameState.GAME_OVER;
  }

  private boolean isCorrectPlayer(GameService gameService) {
    return (player() == 1 && gameService.gameState() == GameState.PLAYER1TURN)
        || (player() == 2 && gameService.gameState() == GameState.PLAYER2TURN);
  }

  private Coordinate coordinate() {
    return CoordinateTranslator.fromMove(Integer.parseInt(square()));
  }

  private boolean isPlay() {
    return command().equals("play");
  }
}
