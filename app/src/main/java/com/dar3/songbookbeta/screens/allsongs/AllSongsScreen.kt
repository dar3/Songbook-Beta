package com.dar3.songbookbeta.screens.allsongs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dar3.songbookbeta.screens.main.MainViewModel

@Composable
fun AllSongsScreen(viewModel: MainViewModel) {

    val songs by viewModel.songsList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadSongs()
    }

    when {
        songs.isEmpty() -> CircularProgressIndicator()
        else ->
            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)

            ) {
                items(songs) { song ->
                    SongItem(song = song)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
    }


}
