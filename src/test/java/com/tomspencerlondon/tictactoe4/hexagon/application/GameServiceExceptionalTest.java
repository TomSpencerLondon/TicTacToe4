package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tomspencerlondon.tictactoe4.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;

public class GameServiceExceptionalTest {
  @Test
  void player1PlaysBeforePlayer2ConnectsThenThrowException() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER2, (GameState gameState, BoardState boardState) -> {
    });

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0), 1))
        .isInstanceOf(GameNotInProgressException.class);
  }

  @Test
  void player1PlaysButNotTheirTurnThenThrowException() {
    GameService gameService = new GameService(
        new TicTacToe(new Board("X__", "___", "___")),
        GameState.PLAYER2TURN, (GameState gameState, BoardState boardState) -> {
    });

    assertThatThrownBy(() -> {
      gameService.play(new Coordinate(0, 1), 1);
    }).isInstanceOf(NotPlayerTurnException.class);
  }

  @Test
  void noOneIsConnectedWhenPlayer1PlaysThenThrowException() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER1, (GameState gameState, BoardState boardState) -> {
    });

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0), 1))
        .isInstanceOf(GameNotInProgressException.class);
  }

  @Test
  void gameIsOverWhenPlayerPlaysThrowsException() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "XOX"
    ));

    GameService gameService = new GameService(ticTacToe, GameState.GAME_OVER, (GameState gameState, BoardState boardState) -> {
    });

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0), 2))
        .isInstanceOf(GameNotInProgressException.class);

  }

  @Test
  void connectForThirdPlayerIsNotAllowed() {
    GameService gameService = new GameService(new TicTacToe(), GameState.PLAYER1TURN, (GameState gameState, BoardState boardState) -> {
    });

    assertThatThrownBy(gameService::connect)
        .isInstanceOf(CantConnectToGameInProgress.class);
  }
}
