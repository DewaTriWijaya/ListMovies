package com.dewatwc.movies.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.vo.Resource


class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<DataMovies>>> =
            moviesRepository.getAllMovies()
}

