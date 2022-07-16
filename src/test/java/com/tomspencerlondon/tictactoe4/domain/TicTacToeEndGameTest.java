package com.tomspencerlondon.tictactoe4.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeEndGameTest {


  @Test
  void newGameOutcomeIsInProgress() {
    TicTacToe ticTacToe = new TicTacToe();
    assertThat(ticTacToe.outcome())
        .isEqualTo("In Progress");

  }

  @Test
  void threeXInTopRowOutcomeIsPlayerWins() {
    TicTacToe ticTacToe = new TicTacToe(
        "XXX",
        "_O_",
        "_O_");

    assertThat(ticTacToe.outcome())
        .isEqualTo("Player wins!");
  }
}
