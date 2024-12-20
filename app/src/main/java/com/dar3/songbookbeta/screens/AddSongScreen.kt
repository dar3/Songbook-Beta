package com.dar3.songbookbeta.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dar3.songbookbeta.Song

@Composable
fun AddSongScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var songName by rememberSaveable { mutableStateOf("") }
        var artistName by rememberSaveable { mutableStateOf("") }
        var songLyrics by rememberSaveable { mutableStateOf("") }
        var songsList by rememberSaveable { mutableStateOf<List<Song>>(emptyList()) }
        var errorMessage by rememberSaveable { mutableStateOf("") }



        TextField(
            value = songName,
            onValueChange = { songName = it },
            label = { Text("Enter song name") },
            maxLines = 2,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        TextField(
            value = artistName,
            onValueChange = { artistName = it },
            label = { Text("Enter song artist") },
            maxLines = 2,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        TextField(
            value = songLyrics,
            onValueChange = { songLyrics = it },
            label = { Text("Enter song lyrics") },
            maxLines = 100,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Button(
            onClick = {

                if (songName.isNotEmpty() && artistName.isNotEmpty() && songLyrics.isNotEmpty()) {
                    val newSong = Song(songName, artistName, songLyrics)
                    songsList = songsList + newSong
                    songName = "" // rest field after clicking save button
                    artistName = ""
                    songLyrics = ""
                    errorMessage = ""
                } else {
                    errorMessage = "Please fill in all fields: name, artist, and lyrics."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text("Save Song", fontWeight = FontWeight.Bold)
        }

        // Showing saved songs list
        Spacer(modifier = Modifier.height(20.dp))
        Text("Saved Songs:")
        songsList.forEach { song ->
            Text("${song.title} - ${song.artist}", style = TextStyle(fontWeight = FontWeight.Bold))
            Text(song.lyrics)
        }
    }
}