package com.example.reisalazar.jogodavelha.model

import java.time.LocalDateTime

data class Game(
    val player1: String,
    val player2: String,
    var boardSize: Int = 3,
    val result: Boolean,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
