package com.example.reisalazar.jogodavelha.model

import java.time.LocalDateTime

data class Game(
    val player: String,
    val opponent: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
