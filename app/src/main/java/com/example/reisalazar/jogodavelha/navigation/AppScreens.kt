package com.example.reisalazar.jogodavelha.navigation

import java.lang.IllegalArgumentException

enum class AppScreens {
    InitialScreen,
    GameScreen,
    HistoryScreen;
    companion object{
        fun fromRoute(route: String?): AppScreens
        = when(route?.substringBefore("/")){
            InitialScreen.name -> InitialScreen
            GameScreen.name -> GameScreen
            HistoryScreen.name -> HistoryScreen
            null -> InitialScreen
            else -> throw IllegalArgumentException("Route $route is not recognized!")
        }
    }
}