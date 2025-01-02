package com.dar3.songbookbeta.screens.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dar3.songbookbeta.data.SongBookApplication


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            MainViewModel(SongBookApplication().container.songsRepository)
        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.SongBookApplication(): SongBookApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SongBookApplication)