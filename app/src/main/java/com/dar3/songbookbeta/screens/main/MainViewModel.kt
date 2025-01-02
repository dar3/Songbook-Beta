package com.dar3.songbookbeta.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dar3.songbookbeta.data.database.SongsRepository
import com.dar3.songbookbeta.screens.allsongs.Song
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(private val songsRepository: SongsRepository) : ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    private val _songsList = MutableStateFlow(emptyList<Song>())
    val songsList = _songsList.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000L)
            _isReady.value = true
        }
    }

    fun loadSongs() {
        viewModelScope.launch(IO) {
            songsRepository.getAllSongs().collectLatest {
                _songsList.tryEmit(it.map { dbSongInstance ->
                    with(dbSongInstance) {
                        Song(title, artist, lyrics)
                    }
                })
            }
        }
    }

    fun insertSong(song: com.dar3.songbookbeta.data.database.Song) {
        viewModelScope.launch(IO) {
            songsRepository.insert(song)
        }
    }
}