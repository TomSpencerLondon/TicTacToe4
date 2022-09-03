package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;

public class GameMessage {
  private String gameState;
  String[][] board;

  public GameMessage(String gameState, String[][] board) {
    this.gameState = gameState;
    this.board = board;
  }

  static GameMessage from(GameState gameState, BoardState board) {
    return new GameMessage(gameState.toString(), board.state());
  }

  public String getGameState() {
    return gameState;
  }

  public String[][] getBoard() {
    return board;
  }
}
