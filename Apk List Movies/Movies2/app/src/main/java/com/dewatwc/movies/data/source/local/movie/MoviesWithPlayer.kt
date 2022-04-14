package com.dewatwc.movies.data.source.local.movie

import androidx.room.Embedded
import androidx.room.Relation

data class MoviesWithPlayer (
    @Embedded
    val mMovies: DataMovies,

    @Relation(parentColumn = "moviesId", entityColumn = "moviesId")
    val mPlayer: List<PlayerMovies>
)