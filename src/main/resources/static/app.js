document.addEventListener("DOMContentLoaded", connect)
let client;

let url = "localhost:8080"
// let url = "toms-tic-tac-toe.herokuapp.com"
function connect() {
  const gameStateDiv = document.getElementById("gameState")
  const player = gameStateDiv.dataset.player
  const id = gameStateDiv.dataset.gameId

  const linkDiv = document.getElementById("shareLink")
  linkDiv.innerHTML = `<button 
class="mt-4 mb-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"
onclick="copyText()">
Copy link to share
</button>`

  const payLoad = {id: id, command: "connect", square: "", player: player}

  client = new StompJs.Client({
    brokerURL: `ws://${url}/websocket`,
    debug: function(str) {
      console.log("debug:", str)
    },
    onConnect: function (frame) {
      client.subscribe(`/topic/tictactoe-${id}`, function (frame) {
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
  const id = gameStateDiv.dataset.gameId
  const payLoad = {id: id, command: "play", square: square, player: player}
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
  createBoard(parsedMessage);
}

function createBoard(parsedMessage) {
  const array = parsedMessage.board
  const board = document.getElementById("board")
  const gameStateDiv = document.getElementById("gameState")
  gameStateDiv.innerText = parsedMessage.gameState
  const linkDiv = document.getElementById("shareLink")
  linkDiv.innerHTML = ''
  newGameButton(parsedMessage)
  let newBoard = '';
  for (let row = 0; row < 3; row++) {
    for (let column = 0; column < 3; column++) {
      if (array[row][column] === "_" && myTurn(parsedMessage.gameState,
          gameStateDiv)) {
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

function newGameButton(parsedMessage) {
  const newGame = document.getElementById("newGame")
  if (parsedMessage.gameState === 'GAME_OVER') {
    const form = `
    <form id="newGame"
          action="/new-game" method="post">
      <button
          type="submit"
          class="mt-8 inline-flex items-center rounded-md border border-transparent bg-green-600 px-4 py-2 text-base font-medium text-white shadow-sm hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2">
        New game
      </button>
    </form>
    `
    newGame.innerHTML = form
  }
}

function copyText() {
  const gameStateDiv = document.getElementById("gameState")
  const id = gameStateDiv.dataset.gameId
  navigator.clipboard.writeText
  (`https://${url}/?id=${id}`);
}