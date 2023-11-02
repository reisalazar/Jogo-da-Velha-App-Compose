package com.example.reisalazar.jogodavelha.screen.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reisalazar.jogodavelha.model.Game
import com.example.reisalazar.jogodavelha.screen.game.GameScreen
import java.time.format.DateTimeFormatter

@Composable
fun HistoryScreen(
//    navController: NavController,
//    games: List<Game>
) {
    Column(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
//        TopAppBar(C) {
        Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()) {
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

    }

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(6.dp)
    ) {
//        items(games) { game ->
//            NoteRow(player = note, onNoteClicked = {
//                onRemoveNote(note)
//            })
    }
}

//@Composable
//fun NoteRow(
//    modifier: Modifier = Modifier,
//    note: Note,
//    onNoteClicked: (Note) -> Unit
//) {
//    Surface(
//        modifier
//            .padding(4.dp)
//            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
//            .fillMaxWidth(),
//        color = Color(0xFF8AB7DD),
//        elevation = 6.dp
//    ) {
//        Column(
//            modifier
//                .clickable { onNoteClicked(note)}
//                .padding(horizontal = 14.dp, vertical = 6.dp),
//            horizontalAlignment = Alignment.Start) {
//            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
//            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
//            Text(
//                text = note.entryDate.format(DateTimeFormatter.ofPattern("dd-mm-yyyy")),
//                style = MaterialTheme.typography.caption
//            )
//        }
//
//    }
//
//}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    HistoryScreen()
}