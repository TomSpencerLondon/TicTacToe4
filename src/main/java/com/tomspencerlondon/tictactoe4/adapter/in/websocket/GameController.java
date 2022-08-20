package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  public GameMessage currentStateOfGame() {
    return new GameMessage("WAITING_FOR_PLAYER2", new String[][]{
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    });
  }
}
