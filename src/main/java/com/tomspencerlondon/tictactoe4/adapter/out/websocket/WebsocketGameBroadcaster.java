package com.tomspencerlondon.tictactoe4.adapter.out.websocket;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.GameBroadcaster;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketGameBroadcaster implements GameBroadcaster {

  private SimpMessagingTemplate template;

  @Autowired
  public WebsocketGameBroadcaster(SimpMessagingTemplate template) {
    this.template = template;
  }


  @Override
  @SendTo("/topic/tictactoe")
  public void send(String id, GameState gameState, BoardState boardState, String errorMessage) {
    template.convertAndSend(
            "/topic/tictactoe-" + id,
            GameMessage.from(gameState, boardState, errorMessage));
  }
}
