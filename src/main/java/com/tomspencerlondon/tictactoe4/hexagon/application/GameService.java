package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToeState;

public class GameService {
  // High level game state field
  // GameState - WaitingForPlayer1, WaitingForPlayer2, Player1Turn, Player2Turn, GameOver
  private final TicTacToe ticTacToe;

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
    return GameState.WAITING_FOR_PLAYER1;
  }
}
