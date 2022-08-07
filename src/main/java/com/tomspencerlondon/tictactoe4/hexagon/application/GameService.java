package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToeState;

public class GameService {
  // High level game state field
  // GameState - WaitingForPlayer1, WaitingForPlayer2, Player1Turn, Player2Turn, GameOver
  private final TicTacToe ticTacToe;
  private GameState gameState = GameState.WAITING_FOR_PLAYER1;

  public GameService(TicTacToe ticTacToe) {
    this.ticTacToe = ticTacToe;
  }

  public BoardState board() {
    return ticTacToe.boardState();
  }

  public TicTacToeState outcome() {
    return ticTacToe.gameState();
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

  public void playerMove(int position) {
    gameState = nextGameState();
  }

  private GameState nextGameState() {
    return gameState == GameState.PLAYER2TURN ? GameState.PLAYER1TURN : GameState.PLAYER2TURN;
  }
}
