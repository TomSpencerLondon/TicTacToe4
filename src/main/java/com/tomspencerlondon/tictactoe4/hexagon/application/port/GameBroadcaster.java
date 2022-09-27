package com.tomspencerlondon.tictactoe4.hexagon.application.port;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;

public interface GameBroadcaster {
  void send(String id, GameState gameState, BoardState boardState, String message);
}
