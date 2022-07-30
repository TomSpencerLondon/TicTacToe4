package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;

public class GameService {

  private final TicTacToe ticTacToe;

  public GameService(TicTacToe ticTacToe) {
    this.ticTacToe = ticTacToe;
  }

  public BoardState board() {
    return ticTacToe.boardState();
  }

  public String outcome() {
    return ticTacToe.outcome();
  }
}
