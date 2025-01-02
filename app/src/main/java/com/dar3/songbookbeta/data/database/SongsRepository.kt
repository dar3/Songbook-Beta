package com.dar3.songbookbeta.data.database


import kotlinx.coroutines.flow.Flow

interface SongsRepository{

    suspend fun insert(song: Song)

    suspend fun getAllSongs(): Flow<List<Song>>

    suspend fun getSongById(id: Int): Flow<Song>
}

class OfflineSongsRepository(private val songDao: SongDao): SongsRepository {

    override suspend fun insert(song: Song)  = songDao.insert(song)


    override suspend fun getAllSongs(): Flow<List<Song>> = songDao.getAllSongs()


    override suspend fun getSongById(id: Int): Flow<Song> = songDao.getSongById(id)


}
