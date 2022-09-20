package com.tomspencerlondon.tictactoe4.adapter.out.websocket;

import static org.mockito.Mockito.verify;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

class WebsocketGameBroadcasterTest {

  @Test
  void givenTwoPlayersConnectedSendsPlayerOneTurnAndBoardState() {
    MessageChannel messageChannel = (message, timeout) -> true;
    SimpMessagingTemplate simpMessagingTemplate = new SimpMessagingTemplate(messageChannel);
    SimpMessagingTemplate template = Mockito.spy(simpMessagingTemplate);
    WebsocketGameBroadcaster broadcaster = new WebsocketGameBroadcaster(template);

    String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
    GameState gameState = GameState.PLAYER1TURN;
    BoardState boardState = BoardState.copyOf(board);
    broadcaster.send(gameState, boardState);

    verify(template)
        .convertAndSend(Mockito.any(String.class), Mockito.any(GameMessage.class));
  }
}