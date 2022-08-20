package com.tomspencerlondon.tictactoe4.hexagon.domain;

public class TicTacToe {

  private final Board board;
  private final WinChecker winChecker = new WinChecker();

  public TicTacToe() {
    board = new Board();
  }

  public TicTacToe(Board board) {
    this.board = board;
  }

  public BoardState boardState() {
    return board.boardState();
  }

  public void play(Coordinate coordinate) {
    board.play(coordinate);
  }

  public GameOutcome outcome() {
    if (playerWins("X")) {
      return GameOutcome.PLAYER_X_WINS;
    } else if (playerWins("O")) {
      return GameOutcome.PLAYER_O_WINS;
    } else if (isDraw()) {
      return GameOutcome.DRAW;
    }

    throw new IllegalStateException();
  }

  private boolean isDraw() {
    return !playerWins("X") && !playerWins("O") && board.isFull();
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board);
  }

  public boolean isWinOrDraw() {
    return playerWins("X") || playerWins("O") || isDraw();
  }
}
