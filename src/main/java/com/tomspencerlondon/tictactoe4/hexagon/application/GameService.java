package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.application.port.GameBroadcaster;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import com.tomspencerlondon.tictactoe4.hexagon.domain.GameOutcome;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;

public class GameService {

  // High level game state field
  // GameState - WaitingForPlayer1, WaitingForPlayer2, Player1Turn, Player2Turn, GameOver
  private final TicTacToe ticTacToe;
  private GameState gameState = GameState.WAITING_FOR_PLAYER1;
  private GameBroadcaster gameBroadcaster;

  public GameService(TicTacToe ticTacToe, GameBroadcaster gameBroadcaster) {
    this.ticTacToe = ticTacToe;
    this.gameBroadcaster = gameBroadcaster;
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
    gameState = gameState.playerConnected();
  }

  public String error() {
    return null;
  }

  public void play(Coordinate coordinate, int player) {
    requireGameInProgress();
    requireCorrectPlayer(player);

    ticTacToe.play(coordinate);

    if (ticTacToe.isWinOrDraw()) {
      gameState = gameState.playerWonOrDraw();
    } else {
      gameState = gameState.playerPlayed();
    }
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
