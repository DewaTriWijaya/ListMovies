package com.dewatwc.movies.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(
        val id: String,
        val title: String,
        val description: String,
        val broadcast: String,
        val imagePath: String
):Parcelable

