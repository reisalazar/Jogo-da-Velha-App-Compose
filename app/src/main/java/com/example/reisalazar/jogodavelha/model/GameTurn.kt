package com.example.reisalazar.jogodavelha.model

import com.example.reisalazar.jogodavelha.Turn

class GameTurn (
        var currentPlayer: Turn = Turn.Player1,
        var winingPlayer: Turn = Turn.Blank,
        var isGamerEnding: Boolean = false,
)
{}