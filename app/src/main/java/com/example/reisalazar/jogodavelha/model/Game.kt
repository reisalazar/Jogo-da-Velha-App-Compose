package com.example.reisalazar.jogodavelha.model

import java.time.LocalDateTime

data class Game(
    val player1: String,
    val player2: String,
    var boardSize: Int = 3,
    var result: Boolean,
    var win:Boolean = true,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
