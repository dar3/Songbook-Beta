package com.dar3.songbookbeta.screens.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dar3.songbookbeta.R
import com.dar3.songbookbeta.screens.AddSongScreen
import com.dar3.songbookbeta.screens.FavouriteSongsScreen
import com.dar3.songbookbeta.screens.LastSongsScreen
import com.dar3.songbookbeta.screens.RandomSongScreen
import com.dar3.songbookbeta.screens.SettingsScreen
import com.dar3.songbookbeta.screens.allsongs.AllSongsScreen
import com.dar3.songbookbeta.screens.home.HomeScreen
import com.dar3.songbookbeta.screens.home.NavItem
import com.dar3.songbookbeta.ui.theme.SongbookBetaTheme

class MainActivity : ComponentActivity() {

    private val viewModel:MainViewModel by viewModels{
        AppViewModelProvider.Factory
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // region Splash screen
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }

            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )

                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )

                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
            }
        }
        enableEdgeToEdge()

        // endregion

        // region Main content
        setContent {
            SongbookBetaTheme {
                val navController = rememberNavController()
                val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        MediumTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text(
                                    getString(R.string.app_name),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = {  navController.navigateUp()}) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Localized description"
                                    )
                                }
                            },

                            scrollBehavior = scrollBehavior
                        )
                    },


                    bottomBar = {
                        BottomNavigationBar(navController)
                    },
                    content = { padding ->
                        Box(modifier = Modifier.padding(padding)) {
                            NavHost(
                                navController = navController,
                                startDestination = "home"
                            ) {
                                composable(BottomNavItem.Home.route) { HomeScreen(navController) }
                                composable(BottomNavItem.Songs.route) { AllSongsScreen() }
                                composable(BottomNavItem.Random.route) { RandomSongScreen() }
                                composable(BottomNavItem.AddSong.route) { AddSongScreen() }
                                composable(BottomNavItem.Settings.route) { SettingsScreen() }
                                composable(NavItem.LastPlayedSongs.route) { LastSongsScreen() }
                                composable(NavItem.FavouriteSongs.route) { FavouriteSongsScreen() }
                            }
                        }
                    }
                )
            }
        }
        //endregion
    }
}