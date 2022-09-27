package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
  private final GameService gameService;

  @Autowired
  public WelcomeController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/")
  public String game(Model model) {
    if (gameService.gameState() == GameState.WAITING_FOR_PLAYER2) {
      model.addAttribute("message", "Waiting for player 1");
      model.addAttribute("player", "2");
    } else {
      model.addAttribute("message", "Connecting to game");
      model.addAttribute("player", "1");
    }

    return "game";
  }

  @PostMapping("/new-game")
  public String newGame() {
    if (gameService.gameState() == GameState.GAME_OVER) {
      gameService.newGame();
    }

    return "redirect:/";
  }
}
