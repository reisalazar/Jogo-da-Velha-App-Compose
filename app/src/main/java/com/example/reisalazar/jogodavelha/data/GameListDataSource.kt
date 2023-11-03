package com.example.reisalazar.jogodavelha.data

import com.example.reisalazar.jogodavelha.model.Game

class GameListDataSource {
    fun loadGame(): List<Game> {
        return listOf(
            Game(player1 = "Testando", player2 = "scrollnoHistórico", 3, true, win = false),
            Game(player1 = "ReinaldoSalazar", player2 = "Jogador2", 3, true, win = true),
            Game(player1 = "Jogador1", player2 = "Bot", 3, false),
            Game(player1 = "ReinaldoSalazar", player2 = "Bot", 3, true, win = false),
            Game(player1 = "Jogador1", player2 = "Bot", 3, true, win = true),
            Game(player1 = "Jogador1", player2 = "UmaPessoa", 3, false),
            Game(player1 = "AZUL", player2 = "VERMELHO", 3, true, win = false),
            Game(player1 = "Jogador1", player2 = "Alguem", 3, false),
            Game(player1 = "ReinaldoSalazar", player2 = "Alguem", 3, true, win = true),
            Game(player1 = "Jogador1", player2 = "OutroAlguem", 3, true, win = false),
            Game(player1 = "Jogador1", player2 = "Bot", 3, true),
            Game(player1 = "Jogador1", player2 = "ReinaldoSalazar", 3, true, win = false),
            Game(player1 = "AZUL", player2 = "VERMELHO", 3, true),
            Game(player1 = "AZUL", player2 = "VERMELHO", 3, true, win = false)
        )
    }
}