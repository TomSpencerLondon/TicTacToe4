document.addEventListener("DOMContentLoaded", connect)
let client;
function connect() {
  const gameStateDiv = document.getElementById("gameState")
  const player = gameStateDiv.dataset.player
  const payLoad = {command: "connect", square: "", player: player}

  client = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/websocket',
    debug: function(str) {
      console.log("debug:", str)
    },
    onConnect: function (frame) {
      client.subscribe("/topic/tictactoe", function (frame) {
        displayBoard(frame.body)
      });
      client.publish({
        destination: "/app/requests",
        body: JSON.stringify(payLoad)
      })
    }
  })
  client.activate()
}

function myTurn(gameState, div) {
  if (gameState === "PLAYER1TURN") {
    return parseInt(div.dataset.player) === 1
  } else if (gameState === "PLAYER2TURN") {
    return parseInt(div.dataset.player) === 2
  }
}

function playerCommand(square) {
  const gameStateDiv = document.getElementById("gameState")
  const player = gameStateDiv.dataset.player
  const payLoad = {command: "play", square: square, player: player}
  client.publish({
    destination: "/app/requests",
    body: JSON.stringify(payLoad)
  })
}

function currentSquare(row, column) {
  return (3 * row) + column
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
    type="button"
    class="h-24 border-solid border-2 border-black cursor-pointer bg-lime-200"
    name="square"
    value="${currentSquare(row, column)}"
    onclick="playerCommand(this.value)"
    >
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

    board.innerHTML = newBoard
  }
}

