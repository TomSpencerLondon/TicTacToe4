document.addEventListener("DOMContentLoaded", connect)

function connect() {
  console.log("connecting...")
  const client = new StompJs.Client()

  client.configure({
    brokerURL: 'ws://localhost:8080/websocket',
    debug: function(str) {
      console.log("debug:", str)
    }
  })

  client.beforeConnect = function() {
    console.log("Before connect!")
  }

  client.onConnect = function(frame){
    console.log("on connect...")
  }
  client.activate();
}


function displayBoard() {
  const gameMessage = `{"gameState":"PLAYER1TURN","board":[["X","_","_"],["_","O","_"],["_","_","_"]]}`
  const parsedMessage = JSON.parse(gameMessage)
  const array = parsedMessage.board
  const board = document.getElementById("board")
  const gameState = document.getElementById("gameState")
  gameState.innerText = parsedMessage.gameState

  for (let row = 0; row < 3; row++) {
    for (let column = 0; column < 3; column++) {
      if (array[row][column] === "_") {
        board.innerHTML += `
<button
    class="h-24 border-solid border-2 border-black cursor-pointer bg-lime-200"
    type="submit" name="square">
</button>
`
      } else {
        board.innerHTML += `
<div
    class="h-24 border-solid border-2 border-black text-center flex justify-center items-center font-extrabold text-3xl">
${array[row][column]}
 </div>
        `
      }
    }
  }
}

