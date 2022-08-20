package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

public class GameMessage {
  private String gameState;
  String[][] board;

  public GameMessage(String gameState, String[][] board) {
    this.gameState = gameState;
    this.board = board;
  }

  public String getGameState() {
    return gameState;
  }

  public String[][] getBoard() {
    return board;
  }
}
