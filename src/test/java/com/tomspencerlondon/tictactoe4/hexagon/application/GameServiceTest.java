package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.tomspencerlondon.tictactoe4.adapter.in.websocket.CoordinateTranslator;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.GameBroadcaster;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.GameOutcome;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameServiceTest {

  @Test
  void givenNewGameServiceGameStateIsWaitingForPlayer1() {
    GameService gameService = new GameService(new TicTacToe(), (GameState gameState, BoardState boardState) -> {
    });

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER1);
  }

  @Test
  void givenPlayerConnectsGameStateIsWaitingForPlayer2() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), gameBroadcaster);

    gameService.connect();

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER2);
    verify(gameBroadcaster, never()).send(Mockito.any(), Mockito.any());
  }

  @Test
  void givenPlayer1ConnectedWhenPlayer2ConnectsIsPlayer1Turn() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), gameBroadcaster);
    gameService.connect();

    gameService.connect();

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER1TURN);
    verify(gameBroadcaster)
        .send(Mockito.any(GameState.class), Mockito.any(BoardState.class));
  }

  @Test
  void givenPlayer1TurnWhenPlayer1MovesIsPlayer2Turn() {
    GameService gameService = createGameServiceWithOnlyPlayerOneConnected();
    gameService.connect();

    gameService.play(CoordinateTranslator.fromMove(1), 1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER2TURN);
  }

  @Test
  void givenPlayer2TurnWhenPlayerMovesIsPlayer1Turn() {
    GameService gameService = new GameService(new TicTacToe(), GameState.PLAYER2TURN);

    gameService.play(CoordinateTranslator.fromMove(2), 2);

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
    GameService gameService = new GameService(ticTacToe, GameState.PLAYER1TURN);

    gameService.play(CoordinateTranslator.fromMove(7), 1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.GAME_OVER);
    assertThat(gameService.outcome())
        .isEqualTo(GameOutcome.DRAW);
  }

  @Test
  void givenGameServiceWithGameOneMoveBeforePlayerXWinsThenGameStateIsGameOver() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "_OX"
    ));
    GameService gameService = new GameService(ticTacToe, GameState.PLAYER1TURN);

    gameService.play(CoordinateTranslator.fromMove(6), 1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.GAME_OVER);
    assertThat(gameService.outcome())
        .isEqualTo(GameOutcome.PLAYER_X_WINS);
  }

  private GameService createGameServiceWithOnlyPlayerOneConnected() {
    GameService gameService = new GameService(new TicTacToe(), (GameState gameState, BoardState boardState) -> {
    });
    gameService.connect();
    return gameService;
  }
}