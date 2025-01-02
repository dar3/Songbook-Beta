package com.dar3.songbookbeta.data

import android.content.Context
import com.dar3.songbookbeta.data.database.DB
import com.dar3.songbookbeta.data.database.OfflineSongsRepository
import com.dar3.songbookbeta.data.database.SongsRepository

interface AppContainer{
    val songsRepository:SongsRepository
}

class AppDataContainer(private val context: Context):AppContainer{
    override val songsRepository: SongsRepository by lazy{OfflineSongsRepository(DB.getDatabase(context).songDao())}
}