package com.dar3.songbookbeta.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dar3.songbookbeta.Song
import com.dar3.songbookbeta.SongItem

@Composable
fun AllSongsScreen() {
    val songs = listOf(
        Song(
            "It's my life",
            "Bon Jovi",
            "This ain't a song for the broken-hearted\n" +
                    "No silent prayer for the faith-departed..."
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
            "Іскра",
            "LuftPauza",
            "Кожного дня у вагоні метро\n" +
                    "Я дивився на обличчя людей..."
        ),
        Song(
            "Wake me up",
            "Avicii",
            "Feeling my way through the darkness\n" +
                    "Guided by a beating heart..."
        ),
        Song(
            "Wkręceni nie ufaj mi",
            "Igor Herbut",
            "Rozszyfruj mnie zdemaskuj blef\n" +
                    "Nie dowierzając unieś swą brew..."
        ),


        Song(
            "Вона",
            "Тарас Чубай",
            "Завтра прийде до кімнати\n" +
                    "твоїх друзів небагато..."
        )
    )



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
