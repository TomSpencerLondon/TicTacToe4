package com.tomspencerlondon.tictactoe4.hexagon.application;

public class GameNotInProgressException extends RuntimeException{

  public GameNotInProgressException(String message) {
    super(message);
  }
}
