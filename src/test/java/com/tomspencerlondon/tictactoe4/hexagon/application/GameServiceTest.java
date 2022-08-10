package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.tictactoe4.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToeState;
import org.junit.jupiter.api.Test;

class GameServiceTest {

  @Test
  void givenNewGameServiceGameStateIsWaitingForPlayer1() {
    GameService gameService = new GameService(new TicTacToe());

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER1);
  }

  @Test
  void givenPlayerConnectsGameStateIsWaitingForPlayer2() {
    GameService gameService = new GameService(new TicTacToe());

    gameService.connect();

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER2);
  }

  @Test
  void givenNewGameServiceAndPlayerConnectsWhenPlayerConnectsIsPlayer1Turn() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();

    gameService.connect();

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER1TURN);
  }

  @Test
  void givenNewGameServiceAndPlayer1TurnWhenPlayerMoveSquareIsPlayer2Turn() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();

    gameService.play(1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER2TURN);
  }

  @Test
  void givenNewGameServiceAndPlayer2TurnWhenPlayerMoveSquareIsPlayer1Turn() {
    GameService gameService = new GameService(new TicTacToe());
    gameService.connect();
    gameService.connect();
    gameService.play(1);

    gameService.play(2);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER1TURN);
  }

  @Test
  void givenGameServiceWithGameOneMoveBeforeDrawWhenPlayerMoveGameStateIsGameOver() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "O_X"
    ));
    GameService gameService = new GameService(ticTacToe);

    gameService.play(7);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.GAME_OVER);
    assertThat(gameService.outcome())
        .isEqualTo(TicTacToeState.DRAW);
  }

  @Test
  void givenGameServiceWithGameOneMoveBeforePlayerXWinsThenGameStateIsGameOver() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "_OX"
    ));
    GameService gameService = new GameService(ticTacToe);

    gameService.play(6);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.GAME_OVER);
    assertThat(gameService.outcome())
        .isEqualTo(TicTacToeState.PLAYER_X_WINS);
  }
}