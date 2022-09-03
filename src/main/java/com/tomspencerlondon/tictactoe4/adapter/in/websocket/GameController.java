package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.Coordinate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
  private static final Logger logger = LoggerFactory.getLogger(GameController.class);
  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @MessageMapping("/requests")
  @SendTo("/topic/tictactoe")
  public GameMessage currentStateOfGame(Message<PlayerPayload> message) {
    PlayerPayload payload = message.getPayload();

    if (payload.command().equals("play")) {
      gameService.play(new Coordinate(0, 0));
    }

    return new GameMessage(
        gameService.gameState().toString(),
        gameService.board().state()
    );
  }
}
