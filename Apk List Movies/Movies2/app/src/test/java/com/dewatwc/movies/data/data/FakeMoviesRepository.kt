package com.dewatwc.movies.data.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dewatwc.movies.data.MoviesDataSource
import com.dewatwc.movies.data.NetworkBoundResource
import com.dewatwc.movies.data.source.local.LocalDataSource
import com.dewatwc.movies.data.source.local.movie.DataMovies
import com.dewatwc.movies.data.source.local.movie.PlayerMovies
import com.dewatwc.movies.data.source.local.movie.MoviesWithPlayer
import com.dewatwc.movies.data.source.remote.ApiResponse
import com.dewatwc.movies.data.source.remote.RemoteDataSource
import com.dewatwc.movies.data.source.remote.response.PlayerResponse
import com.dewatwc.movies.data.source.remote.response.MoviesResponse
import com.dewatwc.movies.utils.AppExecutors
import com.dewatwc.movies.vo.Resource


class FakeMoviesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : MoviesDataSource {




    override fun getAllMovies(): LiveData<Resource<PagedList<DataMovies>>> {
        return object : NetworkBoundResource<PagedList<DataMovies>, List<MoviesResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<DataMovies>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataMovies>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MoviesResponse>) {
                val moviesList = ArrayList<DataMovies>()
                for (response in data) {
                    val movies = DataMovies(response.id,
                        response.title,
                        response.description,
                        response.broadcast,
                        false,
                        response.imagePath)
                    moviesList.add(movies)
                }
                localDataSource.insertMovies(moviesList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<DataMovies>>> {
        return object : NetworkBoundResource<PagedList<DataMovies>, List<MoviesResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<DataMovies>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataMovies>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MoviesResponse>) {
                val moviesList = ArrayList<DataMovies>()
                for (response in data) {
                    val movies = DataMovies(response.id,
                        response.title,
                        response.description,
                        response.broadcast,
                        false,
                        response.imagePath)
                    moviesList.add(movies)
                }

                localDataSource.insertMovies(moviesList)
            }
        }.asLiveData()
    }

    override fun getTvShowMovies(): LiveData<PagedList<DataMovies>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowMovies(), config).build()
    }

    override fun getMoviesWithPlayer(moviesId: String): LiveData<Resource<MoviesWithPlayer>> {
        return object : NetworkBoundResource<MoviesWithPlayer, List<PlayerResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesWithPlayer> =
                localDataSource.getMoviesWithPlayer(moviesId)

            override fun shouldFetch(data: MoviesWithPlayer?): Boolean =
                data?.mPlayer == null || data.mPlayer.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<PlayerResponse>>> =
                remoteDataSource.getPlayer(moviesId)

            override fun saveCallResult(data: List<PlayerResponse>) {
                val playerList = ArrayList<PlayerMovies>()
                for (response in data) {
                    val movies = PlayerMovies(response.playerId,
                        response.moviesId,
                        response.title,
                        response.position,
                        false)

                    playerList.add(movies)
                }

                localDataSource.insertPlayer(playerList)
            }
        }.asLiveData()
    }

    override fun getAllPlayerByMovies(moviesId: String): LiveData<Resource<List<PlayerMovies>>> {
        return object : NetworkBoundResource<List<PlayerMovies>, List<PlayerResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<PlayerMovies>> =
                localDataSource.getAllPlayerByMovies(moviesId)

            override fun shouldFetch(data: List<PlayerMovies>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<PlayerResponse>>> =
                remoteDataSource.getPlayer(moviesId)

            override fun saveCallResult(data: List<PlayerResponse>) {

                val playerList = ArrayList<PlayerMovies>()
                for (response in data) {
                    val player = PlayerMovies(
                        response.playerId,
                        response.moviesId,
                        response.title,
                        response.position,
                        false)

                    playerList.add(player)
                }

                localDataSource.insertPlayer(playerList)

            }
        }.asLiveData()
    }

    override fun setMoviesTvShow(movies: DataMovies, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMoviesTvShow(movies, state) }

    override fun setReadPlayer(Player: PlayerMovies) =
        appExecutors.diskIO().execute { localDataSource.setReadPlayer(Player) }
}

