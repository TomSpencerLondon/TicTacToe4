package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

public record PlayerPayload(String command, String square, int player) {

  boolean isPlay() {
    return command().equals("play");
  }
}
