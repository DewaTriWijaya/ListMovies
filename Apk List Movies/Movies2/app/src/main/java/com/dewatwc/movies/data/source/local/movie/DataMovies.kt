package com.dewatwc.movies.data.source.local.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datamovies")
data class DataMovies(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "moviesId")
        val movieId: String,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "broadcast")
        val broadcast: String,

        @ColumnInfo(name = "tvShow")
        var tvShow: Boolean = false,

        @ColumnInfo(name = "imagePath")
        val imagePath: String
)
