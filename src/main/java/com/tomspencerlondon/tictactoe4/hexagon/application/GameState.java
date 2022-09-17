package com.tomspencerlondon.tictactoe4.hexagon.application;

public enum GameState {
  WAITING_FOR_PLAYER1,
  WAITING_FOR_PLAYER2,

  PLAYER1TURN,
  PLAYER2TURN,

  GAME_OVER;

  boolean gameInProgress() {
    return this == PLAYER1TURN || this == PLAYER2TURN;
  }

  boolean isConnecting() {
    return !gameInProgress() && this != GAME_OVER;
  }

  boolean isCorrectPlayer(int player) {
    return isPlayerOneTurn(player) || isPlayerTwoTurn(player);
  }

  private boolean isPlayerOneTurn(int player) {
    return player == 1 && this == PLAYER1TURN;
  }

  private boolean isPlayerTwoTurn(int player) {
    return player == 2 && this == PLAYER2TURN;
  }

  GameState nextConnectState() {
    return this == WAITING_FOR_PLAYER1 ? WAITING_FOR_PLAYER2 : PLAYER1TURN;
  }

  GameState nextGameState() {
    return this == PLAYER2TURN ? PLAYER1TURN : PLAYER2TURN;
  }

  GameState winOrDraw() {
    if (!gameInProgress()) {
      throw new IllegalStateException();
    }
    return GAME_OVER;
  }
}
