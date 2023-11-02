package com.example.reisalazar.jogodavelha.data

import com.example.reisalazar.jogodavelha.model.Game
import java.time.LocalDateTime

class HistoryDataSource {
    fun loadGame(): List<Game> {
        return listOf(
            Game(player = "Jogador1", opponent = "Bot", true),
            Game(player = "Jogador1", opponent = "Jogador2", true),
            Game(player = "Jogador1", opponent = "Bot", false),
            Game(player = "Jogador1", opponent = "Bot", true),
            Game(player = "Jogador1", opponent = "Bot", true),
            Game(player = "Jogador1", opponent = "Uma Pessoa", false),
            Game(player = "Jogador1", opponent = "Bot", true),
            Game(player = "Jogador1", opponent = "Alguem", false),
            Game(player = "Jogador1", opponent = "Alguem", true),
            Game(player = "Jogador1", opponent = "Outro Alguem", true),
            Game(player = "Jogador1", opponent = "Bot", true),
            Game(player = "Jogador1", opponent = "Alguem", false),
            Game(player = "Jogador1", opponent = "Alguem", true),
            Game(player = "Jogador1", opponent = "Outro Alguem", true)
        )
    }
}