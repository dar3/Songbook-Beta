package com.dar3.songbookbeta.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dar3.songbookbeta.screens.allsongs.Song
import com.dar3.songbookbeta.screens.allsongs.SongItem

@Composable
fun LastSongsScreen() {
    val lastSongs = listOf(
        Song(
            "It's my life",
            "Bon Jovi",
            "This ain't a song for the broken-hearted\n" +
                    "No silent prayer for the faith-departed..."
        ),
        Song(
            "Wake me up",
            "Avicii",
            "Feeling my way through the darkness\n" +
                    "Guided by a beating heart..."
        ),
        Song(
            "Старі фотографії",
            "Скрябін",
            "Здається, шо то було так давно,\n" +
                    "Коли в руках тримаю цей альбом..."
        ),
        Song(
            "Завтра",
            "ТМП",
            "І я з місяцем тихо говорю\n" +
                    "Що наболіло, а що кипить..."
        ),
        Song(
            "Wkręceni nie ufaj mi",
            "Igor Herbut",
            "Rozszyfruj mnie zdemaskuj blef\n" +
                    "Nie dowierzając unieś swą brew..."
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(lastSongs) { song ->
            SongItem(song = song)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

