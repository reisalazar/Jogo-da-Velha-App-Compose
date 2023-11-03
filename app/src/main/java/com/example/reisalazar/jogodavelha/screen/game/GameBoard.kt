package com.example.reisalazar.jogodavelha.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reisalazar.jogodavelha.Turn
import com.example.reisalazar.jogodavelha.model.BoardSpaces
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.model.GameTurn
import com.example.reisalazar.jogodavelha.screen.GameViewModel

@Composable
fun GameBoard(game: Game, gameViewModel: GameViewModel) {
    val cards: List<List<BoardSpaces>> by gameViewModel.getBoardSpaces()
    val currentGame: GameTurn? = gameViewModel.getTurn()
    val currentPlayer: String =
        if (currentGame?.currentPlayer == Turn.Player1) game.player1 else game.player2
    val isGameEnding: Boolean = currentGame?.isGamerEnding == true
    val winningPlayer: String =
        if (currentGame?.winingPlayer == Turn.Player2) game.player2 else game.player1

    Column(
        modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (isGameEnding) {
                Text(
                    text = "Vencedor \uD83C\uDFC6",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                playerTurn(winningPlayer, game)
            } else {
                Text(
                    text = "Vez do Jogador",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                playerTurn(currentPlayer, game)
            }
        }

        Spacer(modifier = Modifier.size(36.dp))

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            cards.forEach { rows ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    rows.forEach { space ->
                        ActionButton(space, gameViewModel = gameViewModel)
                    }
                }
            }

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ActionButton(space: BoardSpaces, gameViewModel: GameViewModel) {
    Card(modifier = Modifier
        .padding(all = 10.dp)
        .border(
            width = 2.dp,
            color = Color.Black,
            shape = RoundedCornerShape(5.dp),
        )
        .height(100.dp)
        .width(100.dp), backgroundColor = Color.White, onClick = {
        gameViewModel.selectBox(space)
    }) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = space.drawSymbol(), fontSize = 34.sp, color = Color.Black
            )
        }
    }
}

@Composable
fun playerTurn(
    currentPlayer: String, game: Game
) {
    if (currentPlayer == game.player1) {
        Text(
            text = currentPlayer,
            style = MaterialTheme.typography.h4,
            color = Color(0XFF007AFF),
            fontWeight = FontWeight.Bold
        )
    } else if (currentPlayer == game.player2) {
        Text(
            text = currentPlayer,
            style = MaterialTheme.typography.h4,
            color = Color(0xFFFF0000),
            fontWeight = FontWeight.Bold
        )
    }
}
