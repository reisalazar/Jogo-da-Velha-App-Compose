package com.example.reisalazar.jogodavelha.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.data.GameListDataSource
import com.example.reisalazar.jogodavelha.model.Game

class GameViewModel : ViewModel() {
    private var gameList = mutableStateListOf<Game>()

    fun addGame(game: Game) {
        Log.d("GAMES", "Games Added")
        this.gameList.add(game)
    }

    fun removeGame(game: Game) {
        this.gameList.remove(game)
    }

    fun getAllGames(): List<Game> {
        return gameList
    }

    fun addMockedGames() {
        Log.d("GAMES", "Games Mocked")
        this.gameList.addAll(GameListDataSource().loadGame())
    }

}