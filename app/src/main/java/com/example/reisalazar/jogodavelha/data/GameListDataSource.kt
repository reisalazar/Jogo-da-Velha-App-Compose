package com.example.reisalazar.jogodavelha.data

import com.example.reisalazar.jogodavelha.model.Game

class GameListDataSource {
    fun loadGame(): List<Game> {
        return listOf(
            Game(player1 = "Testando", player2 = "scroll no histórico", true),
            Game(player1 = "Reinaldo Salazar", player2 = "Jogador2", true),
            Game(player1 = "Jogador1", player2 = "Bot", false),
            Game(player1 = "Reinaldo Salazar", player2 = "Bot", true),
            Game(player1 = "Jogador1", player2 = "Bot", true),
            Game(player1 = "Jogador1", player2 = "Uma Pessoa", false),
            Game(player1 = "Jogador1", player2 = "Bot", true),
            Game(player1 = "Jogador1", player2 = "Alguem", false),
            Game(player1 = "Reinaldo Salazar", player2 = "Alguem", true),
            Game(player1 = "Jogador1", player2 = "Outro Alguem", true),
            Game(player1 = "Jogador1", player2 = "Bot", true),
            Game(player1 = "Jogador1", player2 = "Reinaldo Salazar", false),
            Game(player1 = "Jogador1", player2 = "Alguem", true),
            Game(player1 = "Jogador1", player2 = "Outro Alguem", true)
        )
    }
}