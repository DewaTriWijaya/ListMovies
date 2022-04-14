package com.dewatwc.movies.ui.favorite

import com.dewatwc.movies.data.source.local.movie.DataMovies


interface FavoriteFragmentCallback {
    fun onShareClick(favorite: DataMovies)
}

