package com.dar3.songbookbeta.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dar3.songbookbeta.screens.main.BottomNavItem.AddSong
import com.dar3.songbookbeta.screens.main.BottomNavItem.Home
import com.dar3.songbookbeta.screens.main.BottomNavItem.Random
import com.dar3.songbookbeta.screens.main.BottomNavItem.Settings
import com.dar3.songbookbeta.screens.main.BottomNavItem.Songs

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(Home, Songs, Random, AddSong, Settings)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                label = { Text(text = item.title) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    data object Home : BottomNavItem(
        title = "Home",
        icon = Icons.Filled.Home,
        route = "home"
    )

    data object Songs : BottomNavItem(
        title = "Songs",
        icon = Icons.AutoMirrored.Filled.List,
        route = "allSongs"
    )

    data object Random : BottomNavItem(
        title = "Random",
        icon = Icons.Filled.Face,
        route = "randomSong"
    )

    data object AddSong : BottomNavItem(
        title = "Add song",
        icon = Icons.Filled.AddCircle,
        route = "addSong"
    )

    data object Settings : BottomNavItem(
        title = "Settings",
        icon = Icons.Filled.Settings,
        route = "settings"
    )
}

