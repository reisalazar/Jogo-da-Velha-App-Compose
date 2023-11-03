package com.example.reisalazar.jogodavelha.screen.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.reisalazar.jogodavelha.components.GameRow
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.screen.GameViewModel

@Composable
fun HistoryScreen(
    navController: NavHostController,
    gameViewModel: GameViewModel,
) {
    val games: List<Game> = gameViewModel.getAllGames().reversed()

    Column(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        navController.popBackStack()
                    }, tint = Color(0XFF007AFF)
            )
            Text(
                "Voltar",
                style = MaterialTheme.typography.h4,
                color = Color(0XFF007AFF),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
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