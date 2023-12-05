package tic.tac.toe

class Game {
    private var _lastSymbol = " "
    private val _board: Board = Board()

    fun play(symbol: String, x: Int, y: Int) {
        //if first move
        if (this._lastSymbol == " ") {
            //if player is X
            if (symbol == "") {
                throw RuntimeException("Invalid first player")
            }
        }
        //if not first move but player repeated
        else if (symbol == this._lastSymbol) {
            throw RuntimeException("Invalid next player")
        }
        //if not first move but play on an already played tile
        else if (this._board.tileAt(x, y).symbol != " ") {
            throw RuntimeException("Invalid position")
        }

        // update game state
        this._lastSymbol = symbol
        this._board.addTileAt(symbol, x, y)
    }

    fun winner(): String {
        //if the positions in first row are taken
        if (
            this._board.tileAt(0, 0).symbol != " " &&
            this._board.tileAt(0, 1).symbol != " " &&
            this._board.tileAt(0, 2).symbol != " "
        ) {
            //if first row is full with same symbol
            if (
                this._board.tileAt(0, 0).symbol == this._board.tileAt(0, 1).symbol &&
                this._board.tileAt(0, 2).symbol == this._board.tileAt(0, 1).symbol
            ) {
                return this._board.tileAt(0, 0).symbol
            }
        }

        //if the positions in first row are taken
        if (
            this._board.tileAt(1, 0).symbol != " " &&
            this._board.tileAt(1, 1).symbol != " " &&
            this._board.tileAt(1, 2).symbol != " "
        ) {
            //if middle row is full with same symbol
            if (
                this._board.tileAt(1, 0).symbol == this._board.tileAt(1, 1).symbol &&
                this._board.tileAt(1, 2).symbol == this._board.tileAt(1, 1).symbol
            ) {
                return this._board.tileAt(1, 0).symbol
            }
        }

        //if the positions in first row are taken
        if (
            this._board.tileAt(2, 0).symbol != " " &&
            this._board.tileAt(2, 1).symbol != " " &&
            this._board.tileAt(2, 2).symbol != " "
        ) {
            //if middle row is full with same symbol
            if (
                this._board.tileAt(2, 0).symbol == this._board.tileAt(2, 1).symbol &&
                this._board.tileAt(2, 2).symbol == this._board.tileAt(2, 1).symbol
            ) {
                return this._board.tileAt(2, 0).symbol
            }
        }

        return " "
    }
}

data class Tile(
    val x: Int,
    val y: Int,
    var symbol: String
)

class Board {
    private val _plays: MutableList<Tile> = mutableListOf()

    init {
        (0..2).forEach { i ->
            (0..2).forEach { j ->
                _plays.add(Tile(x = i, y = j, symbol = " "))
            }
        }
    }

    fun tileAt(x: Int, y: Int): Tile = this._plays.find { it.x == x && it.y == y }!!

    fun addTileAt(symbol: String, x: Int, y: Int) {
        this._plays.find { it.x == x && it.y == y }!!.symbol = symbol
    }
}