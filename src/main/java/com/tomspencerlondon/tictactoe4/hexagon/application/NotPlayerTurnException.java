package com.tomspencerlondon.tictactoe4.hexagon.application;

public class NotPlayerTurnException extends RuntimeException {

  public NotPlayerTurnException(String message) {
    super(message);
  }
}
