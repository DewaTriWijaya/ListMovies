package com.dewatwc.movies.data.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.ui.detail.DetailMoviesViewModel
import com.dewatwc.movies.utils.DataDummy
import com.dewatwc.movies.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val moviesId = dummyMovies.movieId


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<MoviesWithPlayer>>

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel(moviesRepository)
        viewModel.setSelectedMovies(moviesId)
    }

    @Test
    fun getMoviesWithPlayer() {
        val dummyMoviesWithPlayer = Resource.success(DataDummy.generateDummyMoviesWithPlayer(dummyMovies, true))
        val movies = MutableLiveData<Resource<MoviesWithPlayer>>()
        movies.value = dummyMoviesWithPlayer

        `when`<LiveData<Resource<MoviesWithPlayer>>>(moviesRepository.getMoviesWithPlayer(moviesId)).thenReturn(movies)

        viewModel.moviesModule.observeForever(observer)

        verify(observer).onChanged(dummyMoviesWithPlayer)
    }
}