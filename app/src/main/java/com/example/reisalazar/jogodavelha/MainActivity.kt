package com.example.reisalazar.jogodavelha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reisalazar.jogodavelha.screen.GameViewModel
import com.example.reisalazar.jogodavelha.screen.HomeScreen
import com.example.reisalazar.jogodavelha.screen.Navigation
import com.example.reisalazar.jogodavelha.screen.game.GameScreen
import com.example.reisalazar.jogodavelha.screen.history.HistoryScreen
import com.example.reisalazar.jogodavelha.ui.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaVelhaTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val gameViewModel: GameViewModel = viewModel()
    val navController = rememberNavController()
    Navigation(navController, gameViewModel)
    gameViewModel.addMockedGames()

}


//@Composable
//fun JogoDaVelhaApp(gameViewModel: GameViewModel = viewModel()) {
//    val gamesList = gameViewModel.getAllGames()
//    HistoryScreen(games = gamesList,
//        onAddGame = {
//            gameViewModel.addGame(it)
//        })
//
//}