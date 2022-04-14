package com.dewatwc.movies.data.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.ui.favorite.FavoriteViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<DataMovies>>

    @Mock
    private lateinit var pagedList: PagedList<DataMovies>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(academyRepository)
    }

    @Test
    fun getFavorite() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(10)
        val courses = MutableLiveData<PagedList<DataMovies>>()
        courses.value = dummyMovies

        `when`(academyRepository.getTvShowMovies()).thenReturn(courses)
        val movies = viewModel.getFavorite().value
        verify<MoviesRepository>(academyRepository).getTvShowMovies()
        assertNotNull(movies)
        assertEquals(10, movies?.size)

        viewModel.getFavorite().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}