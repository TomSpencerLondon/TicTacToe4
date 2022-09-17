package com.tomspencerlondon.tictactoe4.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameStateTest {

  @Test
  void givenGameInProgressWhenWinOrDrawThenStateChangesToGameOver() {
    GameState gameState = GameState.PLAYER1TURN;

    GameState result = gameState.winOrDraw();

    assertThat(result)
        .isEqualByComparingTo(GameState.GAME_OVER);
  }

  @Test
  void givenGameConnectingWhenWinOrDrawThenThrowsException() {
    GameState gameState = GameState.WAITING_FOR_PLAYER1;

    assertThatThrownBy(gameState::winOrDraw).isInstanceOf(IllegalStateException.class);
  }
}