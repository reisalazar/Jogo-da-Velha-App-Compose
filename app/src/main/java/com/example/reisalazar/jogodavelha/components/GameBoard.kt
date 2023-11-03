//package com.example.reisalazar.jogodavelha.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.LiveData
//import com.example.reisalazar.jogodavelha.model.Board
//import com.example.reisalazar.jogodavelha.model.BoardSpaces
//import com.example.reisalazar.jogodavelha.model.Game
//import com.example.reisalazar.jogodavelha.screen.GameViewModel
//
//@Composable
//fun GameBoard(game: Game) {
//    @Composable
//    fun GridButtons(viewModel:GameViewModel) {
//        val cards: List<List<BoardSpaces>> by viewModel.getBoardSpaces().observeAsState(listOf())
//        val currentGame: LiveData<GamerModel> = viewModel.getGamerStatus()
//        var currentPlayer: String = if (currentGame.value?.currentPlayer == Status.PlayerX) "Player X" else "Player O"
//        val isGamerEnding: Boolean = currentGame.value?.isGamerEnding == true
//        val winingPlayer: String = if (currentGame.value?.winingPlayer == Status.PlayerX) "Player X" else "Player O"
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(color = Color.White),
//            verticalArrangement = Arrangement.Center,
//        ) {
//            cards.forEach { rows ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(color = Color.White),
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//                    rows.forEach { card ->
//                        ActionButton(card)
//                    }
//                }
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(color = Color.White),
//                horizontalArrangement = Arrangement.Center,
//            ) {
//                if (isGamerEnding) {
//                    Text(
//                        text = "Wining: $winingPlayer",
//                        fontSize = 28.sp,
//                        color = Color.Black,
//                    )
//                } else {
//                    Text(
//                        text = "Current: $currentPlayer",
//                        fontSize = 28.sp,
//                        color = Color.Black,
//                    )
//                }
//            }
//        }
//    }
//
//    @OptIn(ExperimentalMaterialApi::class)
//    @Composable
//    fun ActionButton(card: BoxModel) {
//        Card(
//            modifier = Modifier
//                .padding(all = 10.dp)
//                .border(
//                    width = 2.dp,
//                    color = Color.Black,
//                    shape = RoundedCornerShape(5.dp),
//                )
//                .height(100.dp)
//                .width(100.dp),
//            backgroundColor = Color.White,
//            onClick = {
//                viewModel.selectBox(card)
//            }
//        ) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center,
//            ) {
//                Text(
//                    text = card.showText(),
//                    fontSize = 34.sp,
//                    color = Color.Black,
//                )
//            }
//        }
//    }
//
//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview() {
//        TicTacToeTheme {
//            MainContent()
//        }
//    }
//}