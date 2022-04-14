package com.dewatwc.movies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dewatwc.movies.data.MoviesRepository
import com.dewatwc.movies.di.Injection
import com.dewatwc.movies.ui.movies.MoviesViewModel
import com.dewatwc.movies.ui.detail.DetailMoviesViewModel
import com.dewatwc.movies.ui.favorite.FavoriteViewModel
//import com.dewatwc.movies.ui.reader.MoviesWithViewModel
import com.dewatwc.movies.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mMoviesRepository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                DetailMoviesViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mMoviesRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
