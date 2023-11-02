package com.example.reisalazar.jogodavelha.screen.history

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.data.HistoryDataSource
import com.example.reisalazar.jogodavelha.model.Game

class HistoryViewModel : ViewModel() {
    var Game = mutableStateListOf<Game>()

    init {
        Game.addAll(HistoryDataSource().loadGame())
    }

    fun addNote(game: Game) {
        Game.add(game)
    }

    fun removeNote(game: Game) {
        Game.remove(game)
    }

    fun getAllNotes(): List<Game> {
        return Game
    }
}