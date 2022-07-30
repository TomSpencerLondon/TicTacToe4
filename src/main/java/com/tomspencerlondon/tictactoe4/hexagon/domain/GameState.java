package com.tomspencerlondon.tictactoe4.hexagon.domain;

public enum GameState {
  PLAYER_X_WINS("Player X wins!"),
  PLAYER_O_WINS("Player O wins!"),
  IN_PROGRESS("In Progress");

  private String value;

  public String getValue() {
    return value;
  }

  GameState(String value) {
    this.value = value;
  }
}