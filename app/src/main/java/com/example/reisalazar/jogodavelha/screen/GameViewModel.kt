package com.example.reisalazar.jogodavelha.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.data.GameListDataSource
import com.example.reisalazar.jogodavelha.model.BoardSpaces
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.model.GameTurn

class GameViewModel : ViewModel() {
    private var gameList = mutableStateListOf<Game>()
    private var boardSpaces = mutableStateOf<List<List<BoardSpaces>>>(emptyList())
    private val gameTurn by mutableStateOf<GameTurn?>(null)

    fun addGame(game: Game) {
        Log.d("GAMES", "Games Added")
        this.gameList.add(game)
    }

    fun getGame(): Game {
        return gameList.last()
    }

    fun getAllGames(): List<Game> {
        return gameList
    }

    fun addMockedGames() {
        Log.d("GAMES", "Games Mocked")
        this.gameList.addAll(GameListDataSource().loadGame())
    }

//    fun getBoardSpaces() = boardSpaces

    fun getTurn() = this.gameTurn

    fun getBoardSpaces() = boardSpaces


}

