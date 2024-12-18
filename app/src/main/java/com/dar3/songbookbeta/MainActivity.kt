package com.dar3.songbookbeta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dar3.songbookbeta.ui.theme.SongbookBetaTheme


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val onClick: () -> Unit = {}
)


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SongbookBetaTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("allSongs") { AllSongsScreen() }
                        composable("randomSong") { RandomSongScreen() }
                        composable("addSong") { AddSongScreen() }
                        composable("settings") { SettingsScreen() }
                        composable("lastPlayedSongs") { LastSongsScreen() }
                        composable("favouriteSongs") { FavouriteSongsScreen() }
                        composable("bonfireSongs") { BonfireSongsScreen() }
                    }
                }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            onClick = { navController.navigate("home") }
        ),
        BottomNavigationItem(
            title = "Songs",
            selectedIcon = Icons.AutoMirrored.Filled.List,
            unselectedIcon = Icons.AutoMirrored.Outlined.List,
            hasNews = false,
            onClick = { navController.navigate("allSongs") }
        ),
        BottomNavigationItem(
            title = "Random",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasNews = false,
            onClick = { navController.navigate("randomSong") }
        ),
        BottomNavigationItem(
            title = "Add song",
            selectedIcon = Icons.Filled.AddCircle,
            unselectedIcon = Icons.Outlined.AddCircle,
            hasNews = false,
            onClick = { navController.navigate("addSong") }
        ),

        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
            onClick = { navController.navigate("settings") }
        )

    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = item.onClick,
                label = { Text(text = item.title) },
                icon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = { navController.navigate("lastPlayedSongs") },

                ) {
                Text("Last played songs")
            }
            Image(
                painter = painterResource(id = R.drawable.circle_arrow_icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = { navController.navigate("favouriteSongs") },

                ) {
                Text("Favourite songs")
            }
            Image(
                painter = painterResource(id = R.drawable.heart_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = { navController.navigate("allSongs") },

                ) {
                Text("All songs")
            }
            Image(
                painter = painterResource(id = R.drawable.three_bars_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = { navController.navigate("bonfireSongs") },

                ) {
                Text("Bonfire songs")
            }
            Image(
                painter = painterResource(id = R.drawable.bonfire_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}


//@Composable
//fun AllSongsScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
//        Text(
//            text = "It's my life",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "Bon Jovi",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "This ain't a song for the broken-hearted\n" +
//                    "No silent prayer for the faith-departed...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray,
//
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//            // next song below
//
//        Text(
//            text = "Старі фотографії",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "Скрябін",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Здається, шо то було так давно,\n" +
//                    "Коли в руках тримаю цей альбом...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray
//        )
//        Spacer(modifier = Modifier.height(16.dp))
////        next song below
//
//        Text(
//            text = "Завтра",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "ТМП",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "І я з місяцем тихо говорю\n" +
//                    "Що наболіло, а що кипить...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Іскра",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "LuftPauza",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Кожного дня у вагоні метро\n" +
//                    "Я дивився на обличчя людей...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Wake me up",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "Avicii",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Feeling my way through the darkness\n" +
//                    "Guided by a beating heart...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Wkręceni nie ufaj mi",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//
//        )
//
//        Text(
//            text = "Igor Herbut",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Rozszyfruj mnie zdemaskuj blef\n" +
//                    "Nie dowierzając unieś swą brew...",
//            fontSize = 15.sp,
//            lineHeight = 20.sp,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        HorizontalDivider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.Gray
//        )
//
//
//    }
//}


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
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        items(songs) { song ->
            SongItem(song = song)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

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


@Composable
fun BonfireSongsScreen() {
    val lastSongs = listOf(


        Song(
            "Лицарський Хрест",
            "Тартак",
            "Дихає ліс,\n" +
                    "Пташка на гіллі..."
        ),
        Song(
            "Завтра",
            "ТМП",
            "І я з місяцем тихо говорю\n" +
                    "Що наболіло, а що кипить..."
        ),

        Song(
            "Дочка мельника",
            "Сергій Фоменко",
            "В мельника, чий млин на горі, чарівна дочка.\n" +
                    "А у мене хата стара і в саду бузочок..."
        ),

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


@SuppressLint("SuspiciousIndentation")
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





