package com.dar3.songbookbeta.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Song::class], version = 1, exportSchema = true)
abstract class DB:RoomDatabase() {

    abstract fun songDao(): SongDao

    companion object {
        @Volatile
        private var Instance: DB? = null

        fun getDatabase(context: Context): DB {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DB::class.java, "Songbook")
                    .createFromAsset("database/songbook_database.db")
                    .build()
                    .also { Instance = it }
            }
        }

    }
}