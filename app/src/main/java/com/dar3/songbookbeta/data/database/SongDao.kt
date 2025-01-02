package com.dar3.songbookbeta.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {

    @Insert
    fun insert(song: Song)

    @Query("SELECT * FROM songs")
    fun getAllSongs():Flow<List<Song>>

    @Query("SELECT * FROM songs WHERE id = :id")
    fun getSongById(id: Int):Flow<Song>



}