package com.example.reisalazar.jogodavelha.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.data.HistoryDataSource
import com.example.reisalazar.jogodavelha.model.Game

class GameViewModel : ViewModel() {
    private var gameList = mutableStateListOf<Game>()

    init {
        gameList.addAll(HistoryDataSource().loadGame())
    }

    fun addGame(game: Game) {
        this.gameList.add(game)
    }

    fun removeGame(game: Game) {
        this.gameList.remove(game)
    }

    fun getAllGames(): List<Game> {
        return gameList
    }
}