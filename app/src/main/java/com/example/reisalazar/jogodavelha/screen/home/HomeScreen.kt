package com.example.reisalazar.jogodavelha.screen.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.reisalazar.jogodavelha.R
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.components.AppTextField
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.screen.GameViewModel

@Composable
fun HomeScreen(
    viewModel: GameViewModel,
    navController: NavHostController
) {
    var selectedOption by remember { mutableStateOf(0) }
    val options = listOf("vs Jogador", "vs Bot")

    var isVisible by remember { mutableStateOf(false) }

    var namePlayer1 by remember {
        mutableStateOf("")
    }
    var namePlayer2 by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    var errorState = false

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

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tipos de Jogo",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                options.forEachIndexed { index, option ->
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = {
                            selectedOption = index
                            isVisible = !isVisible
                        },
                    )
                    Text(text = option)

                }
            }

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
            if (!isVisible) {
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
            } else {
                Spacer(modifier = Modifier.paddingFromBaseline(73.dp))
            }
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
                    if (namePlayer1.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Insira um nome de jogador sem espaços",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (namePlayer1.isNotEmpty() && namePlayer2.isNotEmpty()) {
                        viewModel.addGame(
                            Game(
                                player1 = namePlayer1,
                                player2 = namePlayer2,
                                boardSize = sliderPosition.toInt(),
                                false
                            )
                        )
                        namePlayer1 = ""
                        namePlayer2 = ""
                        navController.navigate("game")

                    } else {
                        viewModel.addGame(
                            Game(
                                player1 = namePlayer1,
                                player2 = "Bot",
                                boardSize = sliderPosition.toInt(),
                                false
                            )
                        )
                        navController.navigate("game")
                    }
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