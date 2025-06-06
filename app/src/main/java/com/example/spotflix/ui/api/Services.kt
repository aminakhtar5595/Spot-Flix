package com.example.spotflix.ui.api

import com.example.spotflix.ui.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String
    ): SearchResponse
}