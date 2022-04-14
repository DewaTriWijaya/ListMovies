package com.dewatwc.movies.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.data.source.local.movie.PlayerMovies


@Database(entities = [DataMovies::class, PlayerMovies::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object {

        @Volatile
        var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context): MoviesDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                            MoviesDatabase::class.java,
                            "Academies.db").build()
                }
    }
}