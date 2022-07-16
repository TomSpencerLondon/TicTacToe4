package com.tomspencerlondon.tictactoe4.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  @Disabled
  void newGameIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe();
//    assertThat(ticTacToe.outcome())
//        .isFalse();

  }

  @Test
  void threeXInTopRowIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(
        "XXX",
        "_O_",
        "_O_");

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }
}
