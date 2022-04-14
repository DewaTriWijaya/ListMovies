package com.dewatwc.movies.utils

import android.content.Context
import com.dewatwc.movies.data.source.remote.response.MoviesResponse
import com.dewatwc.movies.data.source.remote.response.PlayerResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesResponse> {
        val list = ArrayList<MoviesResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("Movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val id = movies.getString("id")
                val title = movies.getString("title")
                val description = movies.getString("description")
                val broadcast = movies.getString("broadcast")
                val imagePath = movies.getString("imagePath")

                val courseResponse = MoviesResponse(id, title, description, broadcast, imagePath)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadPlayer(moviesId: String): List<PlayerResponse> {
        val fileName = String.format("Player_%s.json", moviesId)
        val list = ArrayList<PlayerResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("player")
                for (i in 0 until listArray.length()) {
                    val movies = listArray.getJSONObject(i)

                    val playerId = movies.getString("playerId")
                    val title = movies.getString("title")
                    val position = movies.getString("position")

                    val moviesResponse = PlayerResponse(playerId, moviesId, title, Integer.parseInt(position))
                    list.add(moviesResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }


}

