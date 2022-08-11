package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
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
    return ticTacToe.ticTacToeState();
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
    ticTacToe.play(coordinate);

    if (isWinOrDraw()) {
      gameState = GameState.GAME_OVER;
      return;
    }

    gameState = nextGameState();
  }

  private boolean isWinOrDraw() {
    return (ticTacToe.ticTacToeState() == TicTacToeState.DRAW)
        || (ticTacToe.ticTacToeState() == TicTacToeState.PLAYER_X_WINS)
        || (ticTacToe.ticTacToeState() == TicTacToeState.PLAYER_O_WINS);
  }

  private GameState nextGameState() {
    return gameState == GameState.PLAYER2TURN ? GameState.PLAYER1TURN : GameState.PLAYER2TURN;
  }
}
