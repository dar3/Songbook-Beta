package com.dar3.songbookbeta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Song(val title: String, val artist: String, val lyrics: String)

@Composable
fun SongItem(song: Song) {
    Column(modifier = Modifier.fillMaxWidth())
    {
        Text(
            text = song.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = song.artist,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = song.lyrics,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}