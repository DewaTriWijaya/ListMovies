package com.dewatwc.movies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dewatwc.movies.data.source.local.movie.*
import com.dewatwc.movies.data.source.local.room.MoviesDao


class LocalDataSource private constructor(private val mMoviesDao: MoviesDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: MoviesDao): LocalDataSource {
            return INSTANCE ?: LocalDataSource(academyDao)
        }
    }

    fun getAllMovies(): DataSource.Factory<Int, DataMovies> = mMoviesDao.getMovies()
    fun getAllTvShow(): DataSource.Factory<Int, DataMovies> = mMoviesDao.getTv()


    fun getTvShowMovies(): DataSource.Factory<Int, DataMovies> =
        mMoviesDao.getFavorite()

    fun getMoviesWithPlayer(moviesId: String): LiveData<MoviesWithPlayer> =
        mMoviesDao.getMoviesWithPlayerById(moviesId)

    fun getAllPlayerByMovies(moviesId: String): LiveData<List<PlayerMovies>> =
        mMoviesDao.getPlayerByMoviesId(moviesId)

    fun insertMovies(movies: List<DataMovies>) {
        mMoviesDao.insertMovies(movies) }

    fun insertPlayer(player: List<PlayerMovies>) {
        mMoviesDao.insertPlayer(player) }

    fun setMoviesTvShow(movies: DataMovies, newState: Boolean) {
        movies.tvShow = newState
        mMoviesDao.updateMovies(movies) }

    fun setReadPlayer(player: PlayerMovies) {
        player.read = true
        mMoviesDao.updatePlayer(player)
    }
}