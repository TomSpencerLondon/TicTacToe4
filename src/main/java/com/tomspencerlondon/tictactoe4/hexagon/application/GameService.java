package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import com.tomspencerlondon.tictactoe4.hexagon.domain.GameOutcome;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;

public class GameService {

  // High level game state field
  // GameState - WaitingForPlayer1, WaitingForPlayer2, Player1Turn, Player2Turn, GameOver
  private final TicTacToe ticTacToe;
  private GameState gameState = GameState.WAITING_FOR_PLAYER1;

  public GameService(TicTacToe ticTacToe) {
    this.ticTacToe = ticTacToe;
  }

  GameService(GameState startingState) {
    this(new TicTacToe(), startingState);
  }

  public GameService(TicTacToe ticTacToe, GameState startingState) {
    this.ticTacToe = ticTacToe;
    gameState = startingState;
  }

  public BoardState board() {
    return ticTacToe.boardState();
  }

  public GameOutcome outcome() {
    return ticTacToe.outcome();
  }

  public GameState gameState() {
    return gameState;
  }

  public void connect() {
    if (gameState == GameState.WAITING_FOR_PLAYER1) {
      gameState = GameState.WAITING_FOR_PLAYER2;
      return;
    }

    gameState = GameState.PLAYER1TURN;
  }

  public void play(Coordinate coordinate) {
    if (!gameInProgress()) {
      return;
    }

    ticTacToe.play(coordinate);

    if (ticTacToe.isWinOrDraw()) {
      gameState = GameState.GAME_OVER;
      return;
    }

    gameState = nextGameState();
  }

  private boolean gameInProgress() {
    return gameState == GameState.PLAYER1TURN || gameState == GameState.PLAYER2TURN;
  }

  private GameState nextGameState() {
    return gameState == GameState.PLAYER2TURN ? GameState.PLAYER1TURN : GameState.PLAYER2TURN;
  }
}
