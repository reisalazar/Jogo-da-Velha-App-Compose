package com.example.reisalazar.jogodavelha.screen.game

import android.widget.GridLayout
import android.widget.GridView
import android.widget.Toast
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.model.Game

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen() {
    var turn: Boolean = true
    val game = Game("player1", "opponent", true)
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
                    game.player,
                    style = MaterialTheme.typography.h4,
                    color = Color(0XFF007AFF),
                    fontWeight = FontWeight.Bold
                )
            }else{
                Text(
                    game.opponent,
                    style = MaterialTheme.typography.h4,
                    color = Color(0xFFFF0000),
                    fontWeight = FontWeight.Bold
                )
            }

//            LazyVerticalGrid(cells = GridCells.Fixed(3), content = itemsIndexed)
            val list = (1..10).map { it.toString() }

            LazyColumn {
                itemsIndexed((1..5).map { it.toString() }) { _, row ->
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
                onClick = { }
                )
            AppButton(
                text = "Novo Jogo",
                backgroundColor = Color(0XFFD9EBFF),
                textColor = Color(0XFF007AFF),
                onClick = {})

        }


    }

}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGrid(
    cells: GridCells,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyGridScope.() -> Unit
) {  }

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    GameScreen()
}