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
fun RandomSongScreen() {

    val lastSongs = listOf(
        Song(
            "Україна",
            "Тарас Петриненко",
            "Дороги іншої не треба,\n" +
                    "Поки зорить Чумацький Шлях,\n" +
                    "Я йду від тебе і до тебе\n" +
                    "По золотих твоїх стежках.\n" +
                    "\n" +
                    "Мені не можна не любити,\n" +
                    "Тобі не можна не цвісти,\n" +
                    "Лиш доти варто в світі жити,\n" +
                    "Поки живеш і квітнеш ти!\n" +
                    "\n" +
                    "Приспів:\n" +
                    "Україно, Україно,\n" +
                    "Після далечі доріг\n" +
                    "Вірне серце твого сина\n" +
                    "Я кладу тобі до ніг!\n" +
                    "\n" +
                    "Бо ми кохаєм до нестями\n" +
                    "І ще не скоро наш кінець,\n" +
                    "Ще, може, нашими серцями\n" +
                    "Розпалим тисячі сердець.\n" +
                    "\n" +
                    "Ще свічка наша не згоріла,\n" +
                    "Ще наша молодість при нас,\n" +
                    "А те, чи варте наше діло –\n" +
                    "То скажуть люди й скаже час.\n" +
                    "\n" +
                    "Приспів"
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
