package com.tomspencerlondon.tictactoe4.domain;

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


  public String board() {
    return board.asString();
  }

  public void move(int position) {
    board.play(position, isPlayerMove ? "X" : "O");
    isPlayerMove = !isPlayerMove;
  }

  public String outcome() {
    if (playerWins("X")) {
      return "Player wins!";
    }

    return "In Progress";
  }

  private boolean playerWins(String piece) {
    return winChecker.hasWon(piece, board);
  }

}
