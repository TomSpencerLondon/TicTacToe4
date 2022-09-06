package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tomspencerlondon.tictactoe4.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.junit.jupiter.api.Test;

public class GameServiceExceptionalTest {
  @Test
  void player1PlaysBeforePlayer2Connects() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER2);

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0)))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void noOneIsConnectedWhenPlayer1PlaysThenWaitingForPlayer1() {
    GameService gameService = new GameService(new TicTacToe(), GameState.WAITING_FOR_PLAYER1);

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0)))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void gameIsOverWhenPlayerPlaysThenGameIsStillOver() {
    TicTacToe ticTacToe = new TicTacToe(new Board(
        "OOX",
        "XXO",
        "XOX"
    ));

    GameService gameService = new GameService(ticTacToe, GameState.GAME_OVER);

    assertThatThrownBy(() -> gameService.play(new Coordinate(0, 0)))
        .isInstanceOf(IllegalStateException.class);

  }
}