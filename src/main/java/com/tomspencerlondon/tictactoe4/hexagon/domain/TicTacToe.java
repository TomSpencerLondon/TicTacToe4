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

  public TicTacToeState gameState() {
    if (playerWins("X")) {
      return TicTacToeState.PLAYER_X_WINS;
    } else if (playerWins("O")) {
      return TicTacToeState.PLAYER_O_WINS;
    } else if (isDraw()) {
      return TicTacToeState.DRAW;
    }

    return TicTacToeState.IN_PROGRESS;
  }

  private boolean isDraw() {
    return !playerWins("X") && !playerWins("O") && board.isFull();
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board);
  }

}
