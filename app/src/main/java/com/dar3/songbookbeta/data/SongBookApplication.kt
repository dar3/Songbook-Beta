package com.dar3.songbookbeta.data

import android.app.Application

class SongBookApplication:Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}