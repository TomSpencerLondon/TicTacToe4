package com.tomspencerlondon.tictactoe4.hexagon.application;

import com.tomspencerlondon.tictactoe4.hexagon.application.port.IdGenerator;

public class StubIdGenerator implements IdGenerator {

  @Override
  public String newId() {
    return "windy-dolphin-73";
  }
}
