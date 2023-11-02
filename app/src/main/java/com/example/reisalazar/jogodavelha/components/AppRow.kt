package com.example.reisalazar.jogodavelha.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

//@Composable
//fun AppRow(
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
//                .clickable { onNoteClicked(note) }
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