package com.tomspencerlondon.tictactoe4.adapter.in.web;


import com.github.kkuegler.HumanReadableIdGenerator;
import com.github.kkuegler.PermutationBasedHumanReadableIdGenerator;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.IdGenerator;

public class ReadableIdGenerator implements IdGenerator {
  private final HumanReadableIdGenerator idGen = new PermutationBasedHumanReadableIdGenerator();

  @Override
  public String newId() {
    return idGen.generate();
  }
}
