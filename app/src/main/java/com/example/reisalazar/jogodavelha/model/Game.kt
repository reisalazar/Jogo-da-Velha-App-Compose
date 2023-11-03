package com.example.reisalazar.jogodavelha.model

import java.time.LocalDateTime

data class Game(
    val player1: String,
    val player2: String,
    val Result: Boolean,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
