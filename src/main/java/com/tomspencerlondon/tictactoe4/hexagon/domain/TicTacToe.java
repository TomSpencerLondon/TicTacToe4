package com.tomspencerlondon.tictactoe4.hexagon.domain;

public class TicTacToe {

  private final Board board;
  private boolean isPlayerMove;
  private final WinChecker winChecker = new WinChecker();

  public TicTacToe() {
    board = new Board();
    isPlayerMove = true;
  }

  TicTacToe(Board board) {
    this.board = board;
  }

  public BoardState boardState() {
    return board.boardState();
  }

  public void move(int position) {
    board.play(position, isPlayerMove ? "X" : "O");
    isPlayerMove = !isPlayerMove;
  }

  public GameState gameState() {
    if (playerWins("X")) {
      return GameState.PLAYER_X_WINS;
    } else if (playerWins("O")) {
      return GameState.PLAYER_O_WINS;
    }

    return GameState.IN_PROGRESS;
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board);
  }

}
