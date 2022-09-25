#### Tic Tac Toe - 2 players

#### Event Modelling
State Model
1. Waiting for player 1
=> Player 1 connects
2. Waiting player 2
=> Player 2 connects
3. Game in Progress
  substates:
    == Player 1 turn
      => Player 1 clicks button
    == Player 2 turn
      => Player 2 clicks button
4. Game Over state
  - Player 1 wins
  - Player 2 wins
  - Draw

Event Model
#### State 1 (Waiting for player 1)
1. Server starts up - no-one is connected
2. Tic Tac Toe instance is created
>>> Event - Player 1 connects
3. John (player 1) does a GET request to "/"
>>>
#### State 2 (Waiting for Player 2)
4.
  A) The server responds with text "Waiting for player 2" (GET response - thymeleaf template)
  B) javascript to create websocket connection between server and browser
  C) Upon connection to websocket browser requests the current state of game
  D) Server responds with current state of game ("Waiting for player 2")
>>> Event - Player 2 connects
5. Joe (player 2) does a GET request to "/"
>>>
#### State 3 (Game in Progress: Substate - Player 1 turn)
6.
  A) The server responds with text "Connecting to game" (GET response - thymeleaf template)
  B) javascript to create websocket connection between server and browser
  C) Upon connection to websocket browser requests the current state of game
  D) Server responds with current state of game ("Player 1 turn", squares not clickable)
  E) The server publishes current state of game to John ("Your turn", squares clickable)
7.
  A) John (Should be player 1) plays a square by clicking a button
  [NOTE: possible race condition - possible solution = server assigns player number]
>>> Event - Player 1 moves
  B) javascript sends square to Server via websocket
  C) Server executes Player 1 command
  D) Server queries current state
  E) Server publishes current state of game to both players via websocket
>>>
#### State 3 (Game in Progress: Substate - Player 2 turn)
  F) Server tells Player 1 it is "Player 2 turn"
  G) Server tells Player 2 it is "Your turn"
8.
  A) Joe plays a square by clicking a button
>>> Event - Player 2 moves
  B) javascript sends square to Server via websocket
  C) Server executes Player 2 command
  D) Server queries current state
  E) Server publishes current state of game to both players via websocket
>>>
#### State 4 (Game Over)
  F) Server tells Player 1 it is "You won" / "Player 2 won" / "Draw"
  G) Server tells Player 2 it is "You won" / "Player 1 won" / "Draw"


### Ubiquitous Language
#### Domain Point of View
Play (verb) meaning to play "X" or "O" in a square
Coordinate (noun) represents a chosen square with a coordinate row,column
Piece - (noun) meaning "X" or "O"

#### Web UI Adapter Point of View
Move (noun) represents a chosen square with numbers 0 (top left) - 8 (bottom right)

#### Starter for Websockets

![Screenshot 2022-08-24 at 20 07 50](https://user-images.githubusercontent.com/27693622/186606675-af848092-14bf-48fc-a25e-279918e47131.png)

![gif](https://media.giphy.com/media/JipNO82kfyx3spNJR8/giphy.gif)