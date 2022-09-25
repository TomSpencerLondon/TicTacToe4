package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @MessageMapping("/requests")
  public void playerCommand(Message<PlayerPayload> message) {
    PlayerPayload payload = message.getPayload();
    payload.execute(gameService);
  }
}
