package com.example.reisalazar.jogodavelha.screen.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reisalazar.jogodavelha.data.HistoryDataSource
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.screen.game.GameScreen
import java.time.format.DateTimeFormatter

@Composable
fun HistoryScreen(
//    navController: NavController,
    games: List<Game>
) {
    Column(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
//        TopAppBar(C) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                Modifier
                    .size(50.dp)
                    .clickable {
//                        navController.popBackStack()
                    }, tint = Color(0XFF007AFF)
            )
            Text(
                "Voltar",
                style = MaterialTheme.typography.h4,
                color = Color(0XFF007AFF),
                fontWeight = FontWeight.Bold
            )

        }
        Text(
            modifier = Modifier.padding(top = 36.dp, start = 18.dp),
            text = "Histórico",
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn {
            items(games) { game ->
                GameRow(game = game)
            }
        }
    }
}

@Composable
fun GameRow(
    modifier: Modifier = Modifier,
    game: Game
) {
    Surface(
        modifier
            .padding(4.dp)
            .fillMaxWidth(),
//        color = Color(0xFF8AB7DD),
//        elevation = 6.dp
    ) {
        Column(
            modifier
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {

                
                Text(
                    text = "\uD83C\uDFC6 ${game.player}",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color(0XFF007AFF),
                    fontWeight = FontWeight.Bold
                )

                Text(text = "VS", fontSize = 14.sp, modifier = Modifier.padding(horizontal = 4.dp))

                Text(
                    text = game.opponent,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color(0xFFFF0000),
                    fontWeight = FontWeight.Bold
                )
            }
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

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    HistoryScreen(games = HistoryDataSource().loadGame())

}