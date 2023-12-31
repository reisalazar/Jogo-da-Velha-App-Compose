package com.example.reisalazar.jogodavelha.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reisalazar.jogodavelha.model.Game
import java.time.format.DateTimeFormatter

@Composable
fun GameRow(
    modifier: Modifier = Modifier,
    game: Game
) {
    val winner: String
    val loser: String
    val winnerColor: Long
    val loserColor: Long

    if (game.result) {
        if (game.win) {
            winner = game.player1
            loser = game.player2
            winnerColor = 0XFF007AFF
            loserColor = 0xFFFF0000
        } else {
            winner = game.player2
            loser = game.player1
            winnerColor = 0xFFFF0000
            loserColor = 0XFF007AFF
        }
        Surface(
            modifier
                .padding(4.dp)
                .fillMaxWidth(),
        ) {
            Column(
                modifier
                    .padding(horizontal = 14.dp, vertical = 6.dp),
                horizontalAlignment = Alignment.Start
            ) {
                gameWinner(
                    winner = winner,
                    loser = loser,
                    winnerColor = winnerColor,
                    loserColor = loserColor
                )
                Row(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = game.entryDate.format(DateTimeFormatter.ofPattern("dd-mm-yyyy . hh:mm")),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Gray
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
@Composable
fun gameWinner(winner: String, winnerColor: Long, loser: String, loserColor: Long) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        Text(
            text = "\uD83C\uDFC6 $winner",
            style = MaterialTheme.typography.subtitle1,
            color = Color(winnerColor),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "VS",
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        Text(
            text = loser,
            style = MaterialTheme.typography.subtitle1,
            color = Color(loserColor),
            fontWeight = FontWeight.Bold
        )
    }
}
