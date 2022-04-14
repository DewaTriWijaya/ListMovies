package com.dewatwc.movies.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerResponse(
        val playerId: String,
        val moviesId: String,
        val title: String,
        val position: Int
) : Parcelable

