package com.dar3.songbookbeta.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        TextButton(
            onClick = { /* Tutaj akcja resetu */ }
        ) {
            Column {
                Text(
                    text = "Factory reset",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                Text(
                    text = "Delete favourite songs"
                )
            }
        }
    }
}