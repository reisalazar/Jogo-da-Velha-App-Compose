package com.example.noteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.reisalazar.jogodavelha.model.Game

class GameViewModel: ViewModel() {
    var noteList = mutableStateListOf<Game>()

    init {
//        noteList.addAll(NotesDataSource().loadNote())
    }

    fun addGame(game:Game) {
        noteList.add(game)
    }
//    fun removeNote(game:Game) {
//        noteList.remove(game)
//    }
//
    fun getAllGames() :List<Game> {
        return noteList
    }
}