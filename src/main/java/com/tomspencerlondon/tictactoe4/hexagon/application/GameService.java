package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;

public class GameService {

  private TicTacToe ticTacToe;

  public GameService(TicTacToe ticTacToe) {
    this.ticTacToe = ticTacToe;
  }

  public String board() {
    return ticTacToe.board();
  }
}
