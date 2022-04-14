package com.dewatwc.movies.di

import android.content.Context
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.LocalDataSource
import com.dewatwc.movies.data.source.local.room.MoviesDatabase
import com.dewatwc.movies.data.source.remote.RemoteDataSource
import com.dewatwc.movies.utils.AppExecutors
import com.dewatwc.movies.utils.JsonHelper


object Injection {
    fun provideRepository(context: Context): MoviesRepository {

        val database = MoviesDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.moviesDao())
        val appExecutors = AppExecutors()

        return MoviesRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
