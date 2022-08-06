package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.domain.BoardState;
import com.tomspencerlondon.tictactoe4.hexagon.domain.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/")
  public String game(Model model) {
    BoardState board = gameService.board();
    model.addAttribute("board", board.state());
    GameState outcome = gameService.outcome();
    model.addAttribute("outcome", transform(outcome));
    return "game";
  }

  private String transform(GameState state) {
    if (state == GameState.PLAYER_X_WINS) {
      return "Player X wins!";
    } else if (state == GameState.PLAYER_O_WINS) {
      return "Player O wins!";
    } else if (state == GameState.DRAW) {
      return "Draw!";
    }

    return "In Progress";
  }

}
