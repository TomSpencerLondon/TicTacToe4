package com.tomspencerlondon.tictactoe4;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.GameBroadcaster;
import com.tomspencerlondon.tictactoe4.hexagon.domain.TicTacToe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

  @Bean
  GameService gameService(GameBroadcaster gameBroadcaster) {
    return new GameService(new TicTacToe(), gameBroadcaster);
  }
}
