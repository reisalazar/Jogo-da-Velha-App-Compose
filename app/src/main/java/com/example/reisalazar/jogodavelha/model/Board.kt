package com.example.reisalazar.jogodavelha.model

import com.example.reisalazar.jogodavelha.Turn

class BoardSpaces(
    var turn: Turn = Turn.Blank,
    var indexColumn: Int = 0,
    var indexRow: Int = 0,
) {
    fun drawSymbol(): String {
        return when (turn) {
            Turn.Blank -> ""
            Turn.Player1 -> "X"
            Turn.Player2 -> "O"
        }
    }
}