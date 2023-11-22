package com.michael.movieapp.core.data.source.remote.network

import com.michael.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie")
    suspend fun getList(): ListMovieResponse
}
