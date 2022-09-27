package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import com.tomspencerlondon.tictactoe4.hexagon.application.port.GameBroadcaster;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameServiceExceptionalTest {
  @Test
  void player1PlaysBeforePlayer2ConnectsThenThrowException() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER2, gameBroadcaster);
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.play("windy-dolphin", new Coordinate(0, 0), 1);

    verify(gameBroadcaster).send("windy-dolphin", GameState.WAITING_FOR_PLAYER2, boardState, "Game not in progress");
  }

  @Test
  void player1PlaysButNotTheirTurnThenThrowException() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(
        new TicTacToe(new Board("X__", "___", "___")),
        GameState.PLAYER2TURN, gameBroadcaster);
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"X", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.play("windy-dolphin", new Coordinate(0, 1), 1);

    verify(gameBroadcaster).send("windy-dolphin", GameState.PLAYER2TURN, boardState, "Not player 1 turn");
  }

  @Test
  void noOneIsConnectedWhenPlayer1PlaysThenThrowException() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER1, gameBroadcaster);
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.play("windy-dolphin", new Coordinate(0, 0), 1);

    verify(gameBroadcaster).send("windy-dolphin", GameState.WAITING_FOR_PLAYER1, boardState, "Game not in progress");
  }

  @Test
  void gameIsOverWhenPlayerPlaysThrowsException() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "XOX"
    ));
    GameService gameService = new GameService(ticTacToe, GameState.GAME_OVER, gameBroadcaster);

    gameService.play("windy-dolphin", new Coordinate(0, 0), 2);

    verify(gameBroadcaster).send("windy-dolphin", GameState.GAME_OVER, ticTacToe.boardState(), "Game not in progress");
  }

  @Test
  void connectForThirdPlayerIsNotAllowed() {
    GameService gameService = new GameService(new TicTacToe(), GameState.PLAYER1TURN, (String id, GameState gameState, BoardState boardState, String message) -> {
    });

    assertThatThrownBy(() -> gameService.connect("windy-dolphin"))
        .isInstanceOf(CantConnectToGameInProgress.class);
  }
}
