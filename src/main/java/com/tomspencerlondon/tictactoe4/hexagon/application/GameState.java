package com.tomspencerlondon.tictactoe4.hexagon.application;

public enum GameState {
  WAITING_FOR_PLAYER1, WAITING_FOR_PLAYER2, PLAYER1TURN, PLAYER2TURN, GAME_OVER;

  boolean gameInProgress() {
    return this == PLAYER1TURN || this == PLAYER2TURN;
  }

  boolean isConnecting() {
    return !gameInProgress() && this != GAME_OVER;
  }
}
