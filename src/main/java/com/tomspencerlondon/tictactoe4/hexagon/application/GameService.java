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
    if (!gameState.isConnecting()) {
      throw new IllegalStateException();
    }

    gameState = nextConnectState();
  }

  private GameState nextConnectState() {
    return gameState == GameState.WAITING_FOR_PLAYER1 ? GameState.WAITING_FOR_PLAYER2 : GameState.PLAYER1TURN;
  }

  private GameState nextGameState() {
    return gameState == GameState.PLAYER2TURN ? GameState.PLAYER1TURN : GameState.PLAYER2TURN;
  }

  public String error() {
    return null;
  }

  public void play(Coordinate coordinate, int player) {
    requireGameInProgress();
    requireCorrectPlayer(player);

    ticTacToe.play(coordinate);

    if (ticTacToe.isWinOrDraw()) {
      gameState = GameState.GAME_OVER;
      return;
    }

    gameState = nextGameState();
  }

  private void requireGameInProgress() {
    if (!gameState.gameInProgress()) {
      throw new GameNotInProgressException();
    }
  }

  private void requireCorrectPlayer(int player) {
    if (!gameState.isCorrectPlayer(player)) {
      throw new NotPlayerTurnException();
    }
  }
}
