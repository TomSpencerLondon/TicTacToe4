package com.tomspencerlondon.tictactoe4.adapter.in.web;

import static com.tomspencerlondon.tictactoe4.adapter.in.web.GameStateTranslator.transform;

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

}
