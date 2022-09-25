package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameStateTest {

  @Test
  void givenGameInProgressWhenWinOrDrawThenStateChangesToGameOver() {
    GameState gameState = GameState.PLAYER1TURN;

    GameState result = gameState.playerWonOrDraw();

    assertThat(result)
        .isEqualByComparingTo(GameState.GAME_OVER);
  }

  @Test
  void givenGameConnectingWhenWinOrDrawThenThrowsException() {
    GameState gameState = GameState.WAITING_FOR_PLAYER1;

    assertThatThrownBy(gameState::playerWonOrDraw)
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void givenGameOverWhenWinOrDrawThenThrowsException() {
    GameState gameState = GameState.GAME_OVER;

    assertThatThrownBy(gameState::playerWonOrDraw)
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void givenPlayer1ConnectsThenWaitingForPlayer2() {
    GameState gameState = GameState.WAITING_FOR_PLAYER1;

    GameState result = gameState.playerConnected();

    assertThat(result)
        .isEqualByComparingTo(GameState.WAITING_FOR_PLAYER2);
  }
}