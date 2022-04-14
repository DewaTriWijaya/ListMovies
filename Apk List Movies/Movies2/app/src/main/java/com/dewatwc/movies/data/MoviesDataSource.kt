package com.dewatwc.movies.data


import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.data.source.local.movie.PlayerMovies
import com.dewatwc.movies.vo.Resource


interface MoviesDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<DataMovies>>>
    fun getAllTvShow(): LiveData<Resource<PagedList<DataMovies>>>

    fun getMoviesWithPlayer(moviesId: String): LiveData<Resource<MoviesWithPlayer>>

    fun getAllPlayerByMovies(moviesId: String): LiveData<Resource<List<PlayerMovies>>>

    fun getTvShowMovies(): LiveData<PagedList<DataMovies>>

    fun setMoviesTvShow(movies: DataMovies, state: Boolean)

    fun setReadPlayer(Player: PlayerMovies)
}