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
    GameService gameService = new GameService(new TicTacToe(), (String id, GameState gameState, BoardState boardState, String message) -> {
    });

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER1);
  }

  @Test
  void givenPlayerConnectsGameStateIsWaitingForPlayer2() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), gameBroadcaster);

    gameService.connect("windy-dolphin");

    assertThat(gameService.gameState())
        .isEqualTo(GameState.WAITING_FOR_PLAYER2);
    verify(gameBroadcaster, never()).send(Mockito.any(String.class), Mockito.any(), Mockito.any(), Mockito.any(String.class));
  }

  @Test
  void givenPlayer1ConnectedWhenPlayer2ConnectsIsPlayer1Turn() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), gameBroadcaster);
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });
    gameService.connect("windy-dolphin");

    gameService.connect("windy-dolphin");

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER1TURN);
    verify(gameBroadcaster)
        .send("windy-dolphin", GameState.PLAYER1TURN, boardState, "");
  }

  @Test
  void givenPlayer1TurnWhenPlayer1MovesIsPlayer2Turn() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    GameService gameService = new GameService(new TicTacToe(), gameBroadcaster);
    gameService.connect("windy-dolphin");
    gameService.connect("windy-dolphin");
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "X", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.play("windy-dolphin", CoordinateTranslator.fromMove(1), 1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER2TURN);
    verify(gameBroadcaster).send("windy-dolphin", GameState.PLAYER2TURN, boardState, "");
  }

  @Test
  void givenPlayer2TurnWhenPlayerMovesIsPlayer1Turn() {
    GameBroadcaster gameBroadcaster = Mockito.spy(GameBroadcaster.class);
    Board board = new Board("_X_", "___", "___");
    GameService gameService = new GameService(new TicTacToe(board), GameState.PLAYER2TURN, gameBroadcaster);
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "X", "O"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.play("windy-dolphin", CoordinateTranslator.fromMove(2), 2);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.PLAYER1TURN);
    verify(gameBroadcaster).send("windy-dolphin", GameState.PLAYER1TURN, boardState, "");
  }

  @Test
  void givenGameServiceWithGameOneMoveBeforeDrawWhenPlayerMoveGameStateIsGameOver() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "O_X"
    ));
    GameService gameService = new GameService(ticTacToe, GameState.PLAYER1TURN, (String id, GameState gameState, BoardState boardState, String message) -> {
    });

    gameService.play("windy-dolphin", CoordinateTranslator.fromMove(7), 1);

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
    GameService gameService = new GameService(ticTacToe, GameState.PLAYER1TURN, (String id, GameState gameState, BoardState boardState, String message) -> {
    });

    gameService.play("windy-dolphin", CoordinateTranslator.fromMove(6), 1);

    assertThat(gameService.gameState())
        .isEqualTo(GameState.GAME_OVER);
    assertThat(gameService.outcome())
        .isEqualTo(GameOutcome.PLAYER_X_WINS);
  }

  @Test
  void givenGameOverNewGameStartsNewGame() {
    GameService gameService = new GameService(new TicTacToe(new Board("XOX", "XXO", "X00")), GameState.GAME_OVER, (String id, GameState gameState, BoardState boardState, String message) -> {
    });
    BoardState boardState = BoardState.copyOf(new String[][]{
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });

    gameService.newGame();

    assertThat(gameService.gameState())
        .isEqualByComparingTo(GameState.WAITING_FOR_PLAYER1);
    assertThat(gameService.board())
        .isEqualTo(boardState);
  }
}