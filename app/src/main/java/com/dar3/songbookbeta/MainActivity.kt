package com.dar3.songbookbeta

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
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
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false,
                        onClick = {}
                    ),
                    BottomNavigationItem(
                        title = "Songs",
                        selectedIcon = Icons.AutoMirrored.Filled.List,
                        unselectedIcon = Icons.AutoMirrored.Outlined.List,
                        hasNews = false,
                        onClick = {
                            val intent = Intent(this@MainActivity, AllSongs::class.java)
                            startActivity(intent)
                        }
//                        badgeCount = 45
                    ),
                    BottomNavigationItem(
                        title = "Random",
                        selectedIcon = Icons.Filled.Face,
                        unselectedIcon = Icons.Outlined.Face,
                        hasNews = false,
//                        need to change it to Songs with some random mechanism
                        onClick = {val intent = Intent(this@MainActivity, RandomSong::class.java)
                            startActivity(intent)}
                    ),
                    BottomNavigationItem(
                        title = "Add song",
                        selectedIcon = Icons.Filled.AddCircle,
                        unselectedIcon = Icons.Outlined.AddCircle,
                        hasNews = false,
                        onClick = {
                            val intent = Intent(this@MainActivity, AddSong::class.java)
                            startActivity(intent)
                        }
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                        hasNews = false,
                        onClick = {
                            val intent = Intent(this@MainActivity, Settings::class.java)
                            startActivity(intent)
                        }
                    )

                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            item.onClick()

                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                        alwaysShowLabel = false,
                                        icon = {
                                            BadgedBox(
                                                badge = {
                                                    if(item.badgeCount != null) {
                                                        Badge {
                                                            Text(text = item.badgeCount.toString())
                                                        }
                                                    } else if(item.hasNews) {
                                                        Badge()
                                                    }
                                                }
                                            ) {
                                                Icon(
                                                    imageVector = if (index == selectedItemIndex) {
                                                        item.selectedIcon
                                                    } else item.unselectedIcon,
                                                    contentDescription = item.title
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) {


                        LastSongsButton { buttonText ->
                            when (buttonText) {
                                "LastPlayed" -> {
                                    val intent = Intent(this@MainActivity, LastSongs::class.java)
                                    startActivity(intent)
                                }
                                "AllSongs" -> {
                                    val intent = Intent(this@MainActivity, AllSongs::class.java)
                                    startActivity(intent)
                                }
                                "FavouriteSongs" -> {
                                    val intent = Intent(this@MainActivity, FavouriteSongs::class.java)
                                    startActivity(intent)

                                } "BonfireSongs" -> {
                                val intent = Intent(this@MainActivity, BonfireSongs::class.java)
                                startActivity(intent)
                                }
                            }
                        }




                    }
                }

            }
        }
    }
}


@Composable
fun LastSongsButton(onClick: (String) -> Unit) {
    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextButton(
            onClick = { onClick("LastPlayed") }
        ) {
            Text(text = "Last played songs",
                modifier = Modifier

            )
        }

        TextButton(
            onClick = { onClick("AllSongs") }
        ) {
            Text(text = "All songs",
                modifier = Modifier

            )
        }

        TextButton(
            onClick = { onClick("FavouriteSongs") }
        ) {
            Text(text = "Favourite songs",
                modifier = Modifier

            )
        }

        TextButton(
            onClick = { onClick("BonfireSongs") }
        ) {
            Text(text = "Bonfire songs",
                modifier = Modifier

            )
        }
    }
}




