package com.example.reisalazar.jogodavelha.screen.game

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.screen.GameViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen(navController: NavHostController, GameViewModel: GameViewModel) {
    var turn: Boolean = true
    val game = GameViewModel.getGame()
    Scaffold() {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

            ) {

            Text(
                modifier = Modifier.padding(top = 64.dp),
                text = "Vez do Jogador",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            if (turn) {
                Text(
                    game.player1,
                    style = MaterialTheme.typography.h4,
                    color = Color(0XFF007AFF),
                    fontWeight = FontWeight.Bold
                )
            }else{
                Text(
                    game.player2,
                    style = MaterialTheme.typography.h4,
                    color = Color(0xFFFF0000),
                    fontWeight = FontWeight.Bold
                )
            }

//            LazyVerticalGrid(cells = GridCells.Fixed(3), content = itemsIndexed)
            val list = (1..10).map { it.toString() }

            LazyColumn {
                itemsIndexed((1..3).map { it.toString() }) { _, row ->
                    LazyRow {
                        itemsIndexed(list) { _, column ->

                            Card(
//                                backgroundColor = Color.LightGray,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(4.dp)
                            ) {
//                                Text(
//                                    text = "Row: $row\nCol: $column",
//                                    fontSize = 20.sp,
//                                    textAlign = TextAlign.Center,
//                                    modifier = Modifier.padding(16.dp)
//                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.size(36.dp))

            AppButton(
                text = "Recomeçar",
                backgroundColor = Color(0XFF007AFF),
                textColor = Color.White,
                onClick = {
                    navController.popBackStack()
                    navController.navigate("game")
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
//@Preview(showBackground = true)
//@Composable
//fun GameScreenPreview() {
//    GameScreen()
//}