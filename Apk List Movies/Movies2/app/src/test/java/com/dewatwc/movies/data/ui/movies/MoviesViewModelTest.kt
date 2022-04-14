package com.dewatwc.movies.data.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.ui.movies.MoviesViewModel
import com.dewatwc.movies.vo.Resource
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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<DataMovies>>>

    @Mock
    private lateinit var pagedList: PagedList<DataMovies>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(academyRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(10)
        val movies = MutableLiveData<Resource<PagedList<DataMovies>>>()
        movies.value = dummyMovies

        `when`(academyRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value?.data
        verify(academyRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}