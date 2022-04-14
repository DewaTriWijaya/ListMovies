package com.dewatwc.movies.data.data


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dewatwc.movies.data.source.local.LocalDataSource
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.data.source.local.movie.PlayerMovies
import com.dewatwc.movies.data.source.remote.RemoteDataSource
import com.dewatwc.movies.utils.AppExecutors
import com.dewatwc.movies.utils.DataDummy
import com.dewatwc.movies.vo.Resource
import com.dewatwc.movies.data.utils.LiveDataTestUtil
import com.dewatwc.movies.data.utils.PagedListUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MoviesRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val moviesRepository = FakeMoviesRepository(remote, local, appExecutors)

    private val moviesResponses = DataDummy.generateRemoteDummyMovies()
    private val moviesId = moviesResponses[0].id
    private val playerResponses = DataDummy.generateRemoteDummyPlayer(moviesId)



    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataMovies>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        moviesRepository.getAllMovies()

        val movies = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movies.data)
        assertEquals(moviesResponses.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getAllPlayerByMovies() {
        val dummyModules = MutableLiveData<List<PlayerMovies>>()
        dummyModules.value = DataDummy.generateDummyPlayer(moviesId)
        `when`(local.getAllPlayerByMovies(moviesId)).thenReturn(dummyModules)

        val movies = LiveDataTestUtil.getValue(moviesRepository.getAllPlayerByMovies(moviesId))
        verify(local).getAllPlayerByMovies(moviesId)
        assertNotNull(movies.data)
        assertEquals(playerResponses.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getTvShowMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataMovies>
        `when`(local.getTvShowMovies()).thenReturn(dataSourceFactory)
        moviesRepository.getTvShowMovies()

        val movies = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getTvShowMovies()
        assertNotNull(movies)
        assertEquals(moviesResponses.size.toLong(), movies.data?.size?.toLong())
    }



    @Test
    fun getMoviesWitPlayer() {
        val dummyEntity = MutableLiveData<MoviesWithPlayer>()
        dummyEntity.value = DataDummy.generateDummyMoviesWithPlayer(DataDummy.generateDummyMovies()[0], false)
        `when`<LiveData<MoviesWithPlayer>>(local.getMoviesWithPlayer(moviesId)).thenReturn(dummyEntity)

        val movies = LiveDataTestUtil.getValue(moviesRepository.getMoviesWithPlayer(moviesId))
        verify(local).getMoviesWithPlayer(moviesId)
        assertNotNull(movies.data)
        assertNotNull(movies.data?.mMovies?.title)
        assertEquals(moviesResponses[0].title, movies.data?.mMovies?.title)
    }
}