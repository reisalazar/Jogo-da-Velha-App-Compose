package com.example.reisalazar.jogodavelha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.screen.GameViewModel
import com.example.reisalazar.jogodavelha.ui.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaVelhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val gameViewModel: GameViewModel by viewModels()
//                    JogoDaVelhaApp(gameViewModel = gameViewModel)
                }
            }
        }
    }
}

//@Composable
//fun JogoDaVelhaApp(gameViewModel: GameViewModel = viewModel()) {
//    val notesList = gameViewModel.getAllGames()
//    HistoryScreen(players = notesList,
//        onRemoveNote = {
//            gameViewModel.removeNote(it)
//        },
//        onAddNote = {
//            gameViewModel.addGame(it)
//        })
//
//}