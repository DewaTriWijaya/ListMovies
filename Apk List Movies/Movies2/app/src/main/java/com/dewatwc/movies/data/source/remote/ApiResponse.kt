package com.dewatwc.movies.data.source.remote

import com.dewatwc.movies.data.source.remote.StatusResponse.SUCCESS


class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(SUCCESS, body, null)
    }
}

