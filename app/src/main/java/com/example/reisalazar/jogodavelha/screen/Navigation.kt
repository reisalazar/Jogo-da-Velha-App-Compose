package com.example.reisalazar.jogodavelha.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.reisalazar.jogodavelha.screen.game.GameScreen
import com.example.reisalazar.jogodavelha.screen.history.HistoryScreen

@Composable
fun Navigation(navController: NavHostController, GameViewModel: GameViewModel) {

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                navController = navController,
                viewModel = GameViewModel
            )
        }
        composable("game") {
            GameScreen(
                navController = navController,
                GameViewModel
            )
        }
        composable("history") {
            HistoryScreen(
                navController = navController,
                GameViewModel
            )
        }
    }
}