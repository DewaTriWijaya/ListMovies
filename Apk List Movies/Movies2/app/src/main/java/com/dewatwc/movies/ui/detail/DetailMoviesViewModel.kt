package com.dewatwc.movies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.vo.Resource


class DetailMoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    private val moviesId = MutableLiveData<String>()

    fun setSelectedMovies(moviesId: String) {
        this.moviesId.value = moviesId
    }

    var moviesModule: LiveData<Resource<MoviesWithPlayer>> = Transformations.switchMap(moviesId) { mMoviesId ->
        moviesRepository.getMoviesWithPlayer(mMoviesId)
    }

    fun setTvShow() {
        val playerResource = moviesModule.value
        if (playerResource != null) {
            val moviesWithPlayer = playerResource.data

            if (moviesWithPlayer != null) {
                val courseEntity = moviesWithPlayer.mMovies
                val newState = !courseEntity.tvShow
                moviesRepository.setMoviesTvShow(courseEntity, newState)
            }
        }
    }
}


