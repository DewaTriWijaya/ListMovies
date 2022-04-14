package com.dewatwc.movies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.dewatwc.movies.data.source.local.movie.*


@Dao
interface MoviesDao {

    @Query("SELECT * FROM datamovies")
    fun getMovies(): DataSource.Factory<Int, DataMovies>
    @Query("SELECT * FROM datamovies")
    fun getTv(): DataSource.Factory<Int, DataMovies>

    @Query("SELECT * FROM datamovies where tvShow = 1")
    fun getFavorite(): DataSource.Factory<Int, DataMovies>

    @Transaction
    @Query("SELECT * FROM datamovies WHERE moviesId = :moviesId")
    fun getMoviesWithPlayerById(moviesId: String): LiveData<MoviesWithPlayer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<DataMovies>)

    @Update
    fun updateMovies(movies: DataMovies)

    @Query("SELECT * FROM playermovies WHERE moviesId = :moviesId")
    fun getPlayerByMoviesId(moviesId: String): LiveData<List<PlayerMovies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(player: List<PlayerMovies>)

    @Update
    fun updatePlayer(player: PlayerMovies)

}
