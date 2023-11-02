package com.example.reisalazar.jogodavelha.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reisalazar.jogodavelha.R
import com.example.reisalazar.jogodavelha.components.AppButton
import com.example.reisalazar.jogodavelha.components.AppTextField
import com.example.reisalazar.jogodavelha.model.Game

@Composable
fun InitialScreen(
    onAddNote: (Game) -> Unit,
    onRemoveNote: (Game) -> Unit
) {
    var namePlayer1 by remember {
        mutableStateOf("")
    }
    var namePlayer2 by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Surface(
                modifier = Modifier
                    .padding(32.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Game Logo"
                )
            }

        //Content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Tipos de Jogo", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)



            Spacer(modifier = Modifier.size(10.dp))


            AppTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = namePlayer1,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) namePlayer1 = it
                }
            )
            AppTextField(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = namePlayer2,
                label = "Add a note",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) namePlayer2 = it
                }
            )
            AppButton(
                text = "Começar partida",
                backgroundColor = Color(0XFF007AFF),
                textColor = Color.White,
                onClick = {
                    if (namePlayer1.isNotEmpty() && namePlayer2.isNotEmpty()) {
                        onAddNote(Game(player1 = namePlayer1, player2 = namePlayer2))
                        namePlayer1 = ""
                        namePlayer2 = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    }
                })
            AppButton(
                text = "Histórico de Partidas",
                backgroundColor = Color(0XFFD9EBFF),
                textColor = Color(0XFF007AFF),
                onClick = {
                    if (namePlayer1.isNotEmpty() && namePlayer2.isNotEmpty()) {
                        onAddNote(Game(player1 = namePlayer1, player2 = namePlayer2))
                        namePlayer1 = ""
                        namePlayer2 = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    }
                })
        }

    }
}

@Preview(showBackground = true)
@Composable
fun InitialScreenPreview() {
    InitialScreen(onAddNote = {}, onRemoveNote = {})
}

@Composable
fun MultiChoiceSegmentedButtonRowScope.SegmentedButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    shape: Shape,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    border: SegmentedButtonBorder = SegmentedButtonDefaults.Border,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(checked) },
    label: @Composable () -> Unit
): Unit {
}