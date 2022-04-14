package com.dewatwc.movies.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dewatwc.movies.data.source.remote.response.PlayerResponse
import com.dewatwc.movies.data.source.remote.response.MoviesResponse
import com.dewatwc.movies.utils.EspressoIdlingResource
import com.dewatwc.movies.utils.JsonHelper


@Suppress("DEPRECATION")
class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper)
                }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MoviesResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MoviesResponse>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getPlayer(moviesId: String): LiveData<ApiResponse<List<PlayerResponse>>> {
        EspressoIdlingResource.increment()
        val resultPlayer = MutableLiveData<ApiResponse<List<PlayerResponse>>>()
        handler.postDelayed({
            resultPlayer.value = ApiResponse.success(jsonHelper.loadPlayer(moviesId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultPlayer
    }
}

