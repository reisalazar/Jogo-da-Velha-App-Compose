package com.example.reisalazar.jogodavelha

enum class Turn {
    Blank,
    Player1,
    Player2;

    fun endTurn(): Turn {
        if (this.ordinal == Player1.ordinal) {
            return Player2
        }
        return Player1
    }
}