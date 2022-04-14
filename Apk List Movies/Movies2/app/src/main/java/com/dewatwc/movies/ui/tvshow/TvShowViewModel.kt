package com.dewatwc.movies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.vo.Resource


class TvShowViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<DataMovies>>> =
            moviesRepository.getAllTvShow()
}

