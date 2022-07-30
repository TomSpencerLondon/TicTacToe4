package com.tomspencerlondon.tictactoe4.hexagon.domain;

import java.util.Arrays;

public class BoardFactory {

  public static String[][] empty() {
    String[][] expected = new String[3][3];
    Arrays.fill(expected[0], "_");
    Arrays.fill(expected[1], "_");
    Arrays.fill(expected[2], "_");
    return expected;
  }
}
