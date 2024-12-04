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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
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



@Composable
fun AllSongsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
    }
}


@Composable
fun BonfireSongsScreen() {
    Text("Bonfire Songs Screen",
        modifier = Modifier
            .padding(16.dp),
        )
}

@Composable
fun FavouriteSongsScreen() {
    Text("Favourite Songs Screen",
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun LastSongsScreen() {
    Text("Last Song Screen",
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun RandomSongScreen() {
    Text("Random Song Screen",
        modifier = Modifier
            .padding(16.dp))
}

@Composable
fun AddSongScreen() {
    Text("Add Song Screen",
        modifier = Modifier
            .padding(16.dp))
}

@Composable
fun SettingsScreen() {
    Text("Settings Screen",
        modifier = Modifier
            .padding(16.dp))
}





