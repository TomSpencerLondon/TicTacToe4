package com.tomspencerlondon.tictactoe4.adapter.in.web;

import com.tomspencerlondon.tictactoe4.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe4.hexagon.application.GameState;
import com.tomspencerlondon.tictactoe4.hexagon.application.port.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
  private final GameService gameService;
  private final IdGenerator idGenerator;

  @Autowired
  public WelcomeController(GameService gameService, IdGenerator idGenerator) {
    this.gameService = gameService;
    this.idGenerator = idGenerator;
  }

  @GetMapping("/")
  public String game(Model model, @RequestParam(value = "id", defaultValue = "") String id) {
    if (id.isBlank()) {
      gameService.newGame();
      return "redirect:/?id=" + idGenerator.newId();
    }

    if (gameService.gameState() == GameState.WAITING_FOR_PLAYER2) {
      model.addAttribute("message", "Waiting for player 1");
      model.addAttribute("player", "2");
      model.addAttribute("id", id);
    } else {
      model.addAttribute("message", "Connecting to game");
      model.addAttribute("player", "1");
      model.addAttribute("id", id);
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
