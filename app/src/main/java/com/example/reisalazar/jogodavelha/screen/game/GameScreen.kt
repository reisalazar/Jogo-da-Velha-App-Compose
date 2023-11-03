package com.example.reisalazar.jogodavelha.screen.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.screen.GameViewModel

@Composable
fun GameScreen(navController: NavHostController, gameViewModel: GameViewModel) {
    val game = gameViewModel.getGame()


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GameBoard(game, gameViewModel)
        gameViewModel.loadGamer()

        Column(
            Modifier
                .padding(16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AppButton(
                text = "Recomeçar",
                backgroundColor = Color(0XFF007AFF),
                textColor = Color.White,
                onClick = {
                    gameViewModel.loadGamer()
                }
            )
            AppButton(
                text = "Novo Jogo",
                backgroundColor = Color(0XFFD9EBFF),
                textColor = Color(0XFF007AFF),
                onClick = {
                    navController.popBackStack()
                    navController.navigate("home")

                })
        }
    }
}