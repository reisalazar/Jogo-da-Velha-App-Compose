package com.example.reisalazar.jogodavelha.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.Turn
import com.example.reisalazar.jogodavelha.data.GameListDataSource
import com.example.reisalazar.jogodavelha.model.BoardSpaces
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.model.GameTurn

class GameViewModel : ViewModel() {
    private var gameListState = mutableStateListOf<Game>()
    private var boardSpacesState = mutableStateOf<List<List<BoardSpaces>>>(emptyList())
    private var gameTurnState by mutableStateOf<GameTurn?>(null)

    fun addGame(game: Game) {
        Log.d("GAMES", "Games Added")
        gameListState.add(game)
    }

    fun getGame(): Game {
        return gameListState.last()
    }

    fun getAllGames(): List<Game> {
        return gameListState
    }

    fun addMockedGames() {
        Log.d("GAMES", "Games Mocked")
        this.gameListState.addAll(GameListDataSource().loadGame())
    }

//    fun getBoardSpaces() = boardSpaces

    fun getTurn(): GameTurn? {
    return gameTurnState
}

    fun getBoardSpaces() = boardSpacesState


    fun loadGamer() {
        var indexColumn: Int = 0
        var indexRow: Int = 0

        boardSpacesState.value = MutableList(3) {
            indexRow = 0

            MutableList(3) {
                BoardSpaces(
                        indexColumn = indexColumn++ / 3,
                        indexRow = indexRow++
                )
            }
        }

        gameTurnState = GameTurn()
    }

    fun selectBox(box: BoardSpaces) {
        var currantPlayer: Turn = gameTurnState?.currentPlayer!!
        var hasModification: Boolean = false

        var list: MutableList<MutableList<BoardSpaces>> = boardSpacesState.value.map { columns ->
            var newColumns = columns.map { row ->
                if (box.indexColumn == row.indexColumn && box.indexRow == row.indexRow) {
                    if (row.turn == Turn.Blank) {
                        hasModification = true
                        row.turn = currantPlayer
                    }
                }

                row
            }

            newColumns
        } as MutableList<MutableList<BoardSpaces>>

        if (hasModification && gameTurnState?.isGamerEnding == false) {
            gameTurnState?.currentPlayer = gameTurnState?.currentPlayer!!.endTurn()
            boardSpacesState.value = emptyList()
            boardSpacesState.value = list
        }

        checkEndingGamer()
    }

    private fun checkEndingGamer() {
        // Columns
        (0..2).forEach { index ->
            if (
                    boardSpacesState.value.get(index = index)[0].turn == boardSpacesState.value.get(index = index)[1].turn &&
                    boardSpacesState.value.get(index = index)[1].turn == boardSpacesState.value.get(index = index)[2].turn &&
                    boardSpacesState.value.get(index = index)[2].turn != Turn.Blank
            ) {
                gameTurnState?.isGamerEnding = true
                gameTurnState?.winingPlayer = boardSpacesState.value.get(index = index)[2].turn
            }
        }

        // Row
        (0..2).forEach { index ->
            if (
                    boardSpacesState.value[0].get(index = index).turn == boardSpacesState.value[1].get(index = index).turn &&
                    boardSpacesState.value[1].get(index = index).turn == boardSpacesState.value.get(2).get(index = index).turn &&
                    boardSpacesState.value[2].get(index = index).turn != Turn.Blank
            ) {
                gameTurnState?.isGamerEnding = true
                gameTurnState?.winingPlayer = boardSpacesState.value[2].get(index = index).turn
            }
        }

        // Diagonals
        if (boardSpacesState.value[0][0].turn != boardSpacesState.value[1][1].turn ||
                boardSpacesState.value[1][1].turn != boardSpacesState.value[2][2].turn ||
                boardSpacesState.value[2][2].turn == Turn.Blank) {
        } else {
            gameTurnState?.isGamerEnding = true
            gameTurnState?.winingPlayer = boardSpacesState.value[1][1].turn
        }

        if (
                boardSpacesState.value[0][2].turn == boardSpacesState.value[1][1].turn &&
                boardSpacesState.value[1][1].turn == boardSpacesState.value[2][0].turn &&
                boardSpacesState.value[2][0].turn != Turn.Blank
        ) {
            gameTurnState?.isGamerEnding = true
            gameTurnState?.winingPlayer = boardSpacesState.value[1][1].turn
        }
    }
}

