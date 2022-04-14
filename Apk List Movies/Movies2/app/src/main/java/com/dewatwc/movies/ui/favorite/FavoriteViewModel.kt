package com.dewatwc.movies.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.DataMovies

class FavoriteViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    fun getFavorite(): LiveData<PagedList<DataMovies>> = moviesRepository.getTvShowMovies()

    fun setFavorite(favorite: DataMovies) {
        val newState = !favorite.tvShow
        moviesRepository.setMoviesTvShow(favorite, newState)
    }
}

