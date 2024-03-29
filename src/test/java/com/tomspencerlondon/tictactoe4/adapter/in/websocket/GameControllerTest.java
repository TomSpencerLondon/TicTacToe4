package com.tomspencerlondon.tictactoe4.adapter.in.websocket;

import org.springframework.messaging.support.GenericMessage;

class GameControllerTest {
//
//  @Test
//  void givenOneConnectionThenRequestForCurrentStateOfGameReturnsWaitingForPlayerTwo() {
//    GameService gameService = new GameService(new TicTacToe(), (GameState gameState, BoardState boardState) -> {
//    });
//    gameService.connect();
//    GameController gameController = new GameController(gameService);
//
//    GameMessage gameMessage = gameController.playerCommand(connectMessage("1"));
//
//    assertThat(gameMessage.getGameState()).isEqualTo("WAITING_FOR_PLAYER2");
//    assertThat(gameMessage.getBoard()).isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
//  }
//
//  @Test
//  void givenTwoConnectionsThenRequestForCurrentStateOfGameReturnsPlayerOneTurnWithEmptyBoard() {
//    GameController gameController = controllerWithTwoConnections();
//
//    GameMessage gameMessage = gameController.playerCommand(connectMessage("PLAYER2TURN"));
//
//    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
//    assertThat(gameMessage.getBoard()).isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
//  }
//
//  @Test
//  void givenPlayerOneTurnThenRequestReturnsPlayerTwoTurnAndUpdatedBoard() {
//    GameController gameController = controllerWithTwoConnections();
//
//    GameMessage gameMessage = gameController.playerCommand(playMessage("0", "1"));
//
//    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER2TURN");
//    assertThat(gameMessage.getBoard()).isEqualTo(new String[][]{{"X", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
//  }
//
//  @Test
//  void givenPlayerTwoTurnThenRequestReturnsPlayerOneTurnAndUpdatedBoard() {
//    GameController gameController = controllerWithTwoConnections();
//    gameController.playerCommand(playMessage("0", "1"));
//
//    GameMessage gameMessage = gameController.playerCommand(playMessage("1", "2"));
//
//    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
//    assertThat(gameMessage.getBoard()).isEqualTo(new String[][]{{"X", "O", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
//  }
//
//  @Test
//  void player2PlaysButNotTheirTurn() {
//    GameController gameController = controllerWithTwoConnections();
//
//    GameMessage gameMessage = gameController.playerCommand(playMessage("0", "2"));
//    assertThat(gameMessage.getGameState()).isEqualTo("PLAYER1TURN");
//    assertThat(gameMessage.getBoard()).isEqualTo(new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}});
//    assertThat(gameMessage.getError())
//        .isEqualTo("Error");
//  }
//
//    @Test void playingOccupiedSquareWhenGameIsOverReturnsError() {
//      TicTacToe ticTacToe = new TicTacToe(new Board("XOX", "OXO", "OXX"));
//      GameService gameService = new GameService(ticTacToe, GameState.GAME_OVER);
//      GameController gameController = new GameController(gameService);
//
//      GameMessage gameMessage = gameController.playerCommand(playMessage("3", "1"));
//
//      assertThat(gameMessage.getError()).isEqualTo("Error");
//    }

    private static GenericMessage<PlayerPayload> playMessage (String square,String player){
      return createMessage("play", square, player);
    }

    private static GenericMessage<PlayerPayload> connectMessage (String player){
      return createMessage("connect", "", player);
    }

    private static GenericMessage<PlayerPayload> createMessage (String connect, String square,String player){
      PlayerPayload playerPayload = new PlayerPayload("windy-dolphin", connect, square, player);
      GenericMessage<PlayerPayload> message = new GenericMessage<>(playerPayload);
      return message;
    }

  }