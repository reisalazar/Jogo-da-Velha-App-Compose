package com.example.reisalazar.jogodavelha.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioOptions(
    options: List<String>,
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(options[1] ) }
    Row() {
        options.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 8.dp).padding(vertical = 3.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RadioOptionsPreview() {
//    val listOf = listOf<String>("!", "3", "$")
//    RadioOptions(listOf)
//}
