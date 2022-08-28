document.addEventListener("DOMContentLoaded", connect)

function connect() {
  const client = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/websocket',
    debug: function(str) {
      console.log("debug:", str)
    },
    onConnect: function (frame) {
      client.subscribe("/topic/tictactoe", function (frame) {
        console.log("message: ", frame.body)
        displayBoard(frame.body)
      });

      client.publish({
        destination: "/app/requests",
        body: ""
      })
    }
  })

  client.activate()
}

function myTurn(gameState, div) {
  return gameState === div.dataset.player;
}

function displayBoard(gameMessage) {
  const parsedMessage = JSON.parse(gameMessage)
  const array = parsedMessage.board
  const board = document.getElementById("board")
  const gameStateDiv = document.getElementById("gameState")
  gameStateDiv.innerText = parsedMessage.gameState
  let newBoard = '';
  for (let row = 0; row < 3; row++) {
    for (let column = 0; column < 3; column++) {
      if (array[row][column] === "_" && myTurn(parsedMessage.gameState, gameStateDiv)) {
        newBoard += `
<button
    class="h-24 border-solid border-2 border-black cursor-pointer bg-lime-200"
    type="submit" name="square">
</button>
`
      } else {
        newBoard += `
<div
    class="h-24 border-solid border-2 border-black text-center flex justify-center items-center font-extrabold text-3xl">
${array[row][column]}
 </div>
        `
      }
    }

    board.innerHTML = newBoard;
  }
}

