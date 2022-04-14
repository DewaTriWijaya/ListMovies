package com.dewatwc.movies.data.source.local.movie

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "playermovies",
        primaryKeys = ["playerId", "moviesId"],
        foreignKeys = [ForeignKey(entity = DataMovies::class,
                parentColumns = ["moviesId"],
                childColumns = ["moviesId"])],
        indices = [Index(value = ["playerId"]),
            Index(value = ["moviesId"])])
data class PlayerMovies(
        @NonNull
        @ColumnInfo(name = "playerId")
        val playerId: String,

        @NonNull
        @ColumnInfo(name = "moviesId")
        val moviesId: String,

        @NonNull
        @ColumnInfo(name = "title")
        val title: String,

        @NonNull
        @ColumnInfo(name = "position")
        val position: Int,

        @ColumnInfo(name = "read")
        var read: Boolean = false
)

