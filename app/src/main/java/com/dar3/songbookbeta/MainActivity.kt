package com.dar3.songbookbeta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dar3.songbookbeta.screens.AddSongScreen
import com.dar3.songbookbeta.screens.AllSongsScreen
import com.dar3.songbookbeta.screens.FavouriteSongsScreen
import com.dar3.songbookbeta.screens.HomeScreen
import com.dar3.songbookbeta.screens.LastSongsScreen
import com.dar3.songbookbeta.screens.RandomSongScreen
import com.dar3.songbookbeta.screens.SettingsScreen
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

