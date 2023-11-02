package com.example.reisalazar.jogodavelha.screen.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.reisalazar.jogodavelha.model.Game
import java.time.format.DateTimeFormatter

//@Composable
//fun HistoryScreen(
//    games: List<Game>
//) {
//    LazyColumn {
//        items(games) { game ->
//            NoteRow(player = note, onNoteClicked = {
//                onRemoveNote(note)
//            })
//        }
//    }
//}
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