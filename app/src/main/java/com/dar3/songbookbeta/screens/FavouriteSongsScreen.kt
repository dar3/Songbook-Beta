package com.dar3.songbookbeta.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FavouriteSongsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Lemon Tree",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)

        )

        Text(
            text = "Fools Garden",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "I'm sittin' here in the boring room\n" +
                    "It's just another rainy Sunday afternoon...",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray,

            )

        Spacer(modifier = Modifier.height(16.dp))
        // next song below

        Text(
            text = "Старі фотографії",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)

        )

        Text(
            text = "Скрябін",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Здається, шо то було так давно,\n" +
                    "Коли в руках тримаю цей альбом...",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "It's my life",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)

        )

        Text(
            text = "Bon Jovi",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "This ain't a song for the broken-hearted\n" +
                    "No silent prayer for the faith-departed...",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray,

            )
    }
}