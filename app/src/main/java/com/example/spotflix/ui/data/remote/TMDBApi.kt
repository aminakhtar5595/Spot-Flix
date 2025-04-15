package com.example.spotflix.ui.data.remote
import com.example.spotflix.ui.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String
    ): MovieResponse
}