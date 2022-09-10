package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;

public class GameMessage {
  private String gameState;
  String[][] board;
  private String error;

  public GameMessage(String gameState, String[][] board, String error) {
    this.gameState = gameState;
    this.board = board;
    this.error = error;
  }

  static GameMessage from(GameState gameState, BoardState board, String error) {
    return new GameMessage(gameState.toString(), board.state(), error);
  }

  public String getGameState() {
    return gameState;
  }

  public String[][] getBoard() {
    return board;
  }

  public String getError() {
    return error;
  }
}
