package com.example.reisalazar.jogodavelha.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.reisalazar.jogodavelha.R
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.components.AppTextField
import com.example.reisalazar.jogodavelha.components.RadioOptions
import com.example.reisalazar.jogodavelha.model.Game

@Composable
fun HomeScreen(
    viewModel: GameViewModel,
    navController: NavHostController
) {
    var namePlayer1 by remember {
        mutableStateOf("")
    }
    var namePlayer2 by remember {
        mutableStateOf("")
    }
    var sliderPosition by remember { mutableStateOf(3f) }

    Column(
        modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Game Logo"
            )
        }

        //Content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tipos de Jogo",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )

            RadioOptions(listOf("vs Jogador", "vs Bot"))

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Nome dos Jogadores",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )

            AppTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = namePlayer1,
                label = "Jogador 1",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) namePlayer1 = it
                }
            )
            AppTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = namePlayer2,
                label = "Jogador 2",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) namePlayer2 = it
                }
            )

            Spacer(modifier = Modifier.size(36.dp))
            Text(
                text = "Tamanho do tabuleiro",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = sliderPosition.toInt().toString(),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )

            Slider(value = sliderPosition,
                valueRange = 3f..10f,
                enabled = true,
                steps = 6,
                onValueChange = {
                    sliderPosition = it
                })

            Spacer(modifier = Modifier.size(36.dp))

            AppButton(
                text = "Começar partida",
                backgroundColor = Color(0XFF007AFF),
                textColor = Color.White,
                onClick = {
                    if (namePlayer1.isNotEmpty() && namePlayer2.isNotEmpty()) {
                        viewModel.addGame(Game(player1 = namePlayer1, player2 = namePlayer2, true))
                        namePlayer1 = ""
                        namePlayer2 = ""
                    }else{
                        viewModel.addGame(Game(player1 = namePlayer1, player2 = "Bot", true))
                    }
                    navController.navigate("game")
                })
            AppButton(
                text = "Histórico de Partidas",
                backgroundColor = Color(0XFFD9EBFF),
                textColor = Color(0XFF007AFF),
                onClick = {
                    navController.navigate("history")
                })
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun InitialScreenPreview() {
//    HomeScreen()
//}
