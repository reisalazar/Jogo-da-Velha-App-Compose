package com.example.reisalazar.jogodavelha.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OpponentRow(
    opponent: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier.padding(4.dp),
    ) {
        Column(
            modifier
                .clickable {}
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {

        }
        Text(text = opponent, style = MaterialTheme.typography.subtitle2)
    }
}
