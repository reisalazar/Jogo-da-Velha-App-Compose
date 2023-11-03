package com.example.reisalazar.jogodavelha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.reisalazar.jogodavelha.model.BoardSpaces
import com.example.reisalazar.jogodavelha.model.GameTurn
import com.example.reisalazar.jogodavelha.screen.GameViewModel
import com.example.reisalazar.jogodavelha.screen.Navigation
import com.example.reisalazar.jogodavelha.ui.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaVelhaTheme {
                MyApp()
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

    @Composable
    fun GameBoard() {
        val cards: List<List<BoardSpaces>> by gameViewModel.getBoardSpaces()
        val currentGame: GameTurn? = gameViewModel.getTurn()
        var currentPlayer: String =
                if (currentGame?.currentPlayer == Turn.Player1) "Player 1" else "Player 2"
        val isGamerEnding: Boolean = currentGame?.isGamerEnding == true
        val winingPlayer: String =
                if (currentGame?.winingPlayer == Turn.Player2) "Player 1" else "Player 2"

        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
        ) {
            cards.forEach { rows ->
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White),
                        horizontalArrangement = Arrangement.SpaceAround
                ) {
                    rows.forEach { card ->
                        ActionButton(card)
                    }
                }
            }

            Row(
                    modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White),
                    horizontalArrangement = Arrangement.Center,
            ) {
                if (isGamerEnding) {
                    Text(
                            text = "Wining: $winingPlayer",
                            fontSize = 28.sp,
                            color = Color.Black,
                    )
                } else {
                    Text(
                            text = "Current: $currentPlayer",
                            fontSize = 28.sp,
                            color = Color.Black,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ActionButton(card: BoardSpaces) {
        Card(
                modifier = Modifier
                        .padding(all = 10.dp)
                        .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(5.dp),
                        )
                        .height(100.dp)
                        .width(100.dp),
                backgroundColor = Color.White,
                onClick = {
//                    viewModel.selectBox(card)
                }
        ) {
            Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
            ) {
//                Text(
//                        text = card.showText(),
//                        fontSize = 34.sp,
//                        color = Color.Black
//                )
            }
        }
    }
}
